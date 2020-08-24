package sec04.exam01_hashmap;

import java.util.Objects;

public class Student {
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            return sno == student.sno && name.equals(student.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, name);
    }
}
