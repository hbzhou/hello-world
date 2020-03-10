package com.itsz.java.xml;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XmlParseTest {

    @Test
    public void testParseXml() throws IOException, JAXBException {
        Student student = XmlParser.parse("student.xml", Student.class);
        System.out.println(student);
    }

    @Test
    public  void testParseXmlWithPatter () throws IOException {
        Map<String, Student> studentMap = XmlParser.parseWithPattern("classpath:student.xml", Student.class);
        studentMap.forEach((s, student) -> System.out.println(s+"-------"+student));
    }

    @Test
    public void testParseReturnList() throws IOException {
        List<Student> students = XmlParser.parseReturnList("classpath:student.xml", Student.class);
        students.stream().forEach(System.out::println);
    }


}
