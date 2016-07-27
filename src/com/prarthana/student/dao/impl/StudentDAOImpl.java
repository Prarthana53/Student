/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.student.dao.impl;

import com.prarthana.student.dao.StudentDAO;
import com.prarthana.student.stud.Student;

/**
 *
 * @author Pavilion G4
 */
public class StudentDAOImpl implements StudentDAO{
    private int counter=0;
    private Student[] studentList=new Student[3];

    @Override
    public boolean insert(Student s) {
        
        if(counter==studentList.length){
            return false;
        }
      studentList[counter]=s;
      counter++;
        return true;
     
      
    }

    @Override
    public boolean update(Student s) {
        return true;
        
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<studentList.length;i++){
        Student s=studentList[i]; 
        if(s!=null && s.getId()==id){
            studentList[i]=null;
            return true;
        }
        
        }
        return false;
        
    }


    @Override
    public Student getById(int id) {
        for(int i=0;i<studentList.length;i++){
        Student s=studentList[i]; 
        if(s!=null && s.getId()==id){
            
            return s;
        }
        
        }
        return null;
       
    }

    @Override
    public Student[] getAll() {
       return studentList;
    }
    
}
