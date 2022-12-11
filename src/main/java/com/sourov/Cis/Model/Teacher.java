package com.sourov.Cis.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false,length = 30)
    private String name;
    @Column(nullable = false,length = 30)
    private  String employee_id;
    @Column(nullable = false,length = 30)
    private  String Subject;
    @Column(nullable = false,length = 30)
    private String studentname;
    @Column(nullable = false,length = 20)
    public double totalmark;
    public double cgpa(){
      if (totalmark>93) {
          setTotalmark(4);
      }else if(totalmark<=92 && totalmark>=90){
          setTotalmark(3.7);
      }else if (totalmark<=89 && totalmark>=87 ){
          setTotalmark(3.3);
      }else if (totalmark<= 86 & totalmark>=83){
          setTotalmark(2.7);
      } else if (totalmark<= 82 && totalmark>=80) {
          setTotalmark(2.3);
      } else if (totalmark<= 79 && totalmark>= 73) {
          setTotalmark(2.0);
      } else if (totalmark<= 72 && totalmark>= 68) {
          setTotalmark(1.7);
      } else if (totalmark<=67 && totalmark>=59) {
          setTotalmark(1.0);
      } else if (totalmark<=60 && totalmark>=0 ) {
          setTotalmark(0.0);
      }
        return totalmark;
    }
    @Column(nullable = false,length = 20)
    private String studentid;




}
