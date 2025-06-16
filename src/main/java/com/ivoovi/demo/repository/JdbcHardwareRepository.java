package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.domain.Type;
import com.ivoovi.demo.dto.HardwareDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Primary
public class JdbcHardwareRepository implements HardwareRepository{
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean hardwareByIdExists(Integer id) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM HARDWARE WHERE ID =?",Integer.class,id);
        return count>0;
    }


    @Override
    public boolean deleteHardware(Integer id) {
        if(hardwareByIdExists(id)){
            Integer count = jdbcTemplate.update("DELETE FROM HARDWARE WHERE ID =?",Integer.class,id);
            return true;
        }
        return false;
    }

    @Override
    public List<Hardware> getAllHardware() {
        return jdbcTemplate.query("SELECT * FROM HARDWARE", new HardwareMapper());
    }

    @Override
    public List<Hardware> getHardwareBySifra(String sifra) {
        return jdbcTemplate.query("SELECT * FROM HARDWARE WHERE SIFRA = ?",new HardwareMapper(),sifra);
    }

    @Override
    public Hardware saveNewHardware(Hardware hardware) {
      final String SQL ="" +
              "SELECT ID FROM FINAL TABLE(INSERT INTO HARDWARE(naziv,sifra, cijena ,typeId,kolicina) VALUES(?,?,?,?,?)) HARDWARE";
      Integer generatedId = jdbcTemplate
              .queryForObject(SQL,Integer.class,
                      hardware.getNaziv(),hardware.getSifra(),hardware.getCijena(),hardware.getType().getId(),hardware.getKolicina());
      hardware.setId(generatedId);
      return hardware;
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id) {
        if(hardwareByIdExists(id)){
            final String SQL ="UPDATE HARDWARE SET naziv=?,sifra=?, cijena =?,typeId=?,kolicina=? WHERE ID =?";
            jdbcTemplate.update(
                    connection ->{
                        PreparedStatement ps = connection.prepareStatement(SQL);
                        ps.setString(1, hardwareToUpdate.getNaziv());
                        ps.setString(2, hardwareToUpdate.getSifra());
                        ps.setDouble(3,hardwareToUpdate.getCijena());
                        ps.setInt(4,hardwareToUpdate.getType().getId());
                        ps.setInt(5,hardwareToUpdate.getKolicina());
                        ps.setInt(6,id);
                        return ps;
                    }
            );
            hardwareToUpdate.setId(id);
            return Optional.of(hardwareToUpdate);
        }
        else {
            return Optional.empty();
        }
    }
    public static class HardwareMapper implements RowMapper<Hardware>{

        @Override
        public Hardware mapRow(ResultSet rs, int rowNum) throws SQLException {

            Hardware newHardware = new Hardware();
            newHardware.setId(rs.getInt("ID"));
            newHardware.setNaziv(rs.getString("NAZIV"));
            newHardware.setSifra(rs.getString("SIFRA"));
            newHardware.setCijena(rs.getDouble("CIJENA"));
            Integer typeId = rs.getInt("TYPEID");

            if (Type.CPU.getId().equals(typeId)){
                newHardware.setType(Type.CPU);
            }else {
                newHardware.setType(Type.GPU);
            }
            return newHardware;
        }
    }
}
