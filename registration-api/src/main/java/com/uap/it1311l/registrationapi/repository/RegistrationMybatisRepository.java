package com.uap.it1311l.registrationapi.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

import com.uap.it1311l.registrationapi.model.Attendee;

@Mapper
public interface RegistrationMybatisRepository {

    @Insert("INSERT INTO attendees(firstName, middleName, lastName, course, age) VALUES (#{firstName}, #{middleName}, #{lastName}, #{course},#{age})")
    public int insert(Attendee attendee);

    @Select("SELECT * FROM attendees")
    public List<Attendee> findAll();
    
    @Update("UPDATE attendees SET surveyEligibilityTag = true WHERE course = 'BSIT'")
    int markBSITAttendeesEligibleForSurvey();

    @Delete("DELETE FROM attendees WHERE attendeeId = #{id}")
    int deleteById(String id);

    

}
