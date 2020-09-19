package first.docotsubu.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import first.docotsubu.entity.Mutter;

@Mapper
public interface MutterRepository {
    @Select("SELECT name, text FROM mutter ORDER BY id DESC")
    List<Mutter> selectAll();

    @Insert("INSERT INTO mutter(name, text) VALUES(#{name}, #{text})")
    void insert(Mutter mutter);
}
