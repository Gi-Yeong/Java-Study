package sec04.exam01_objects;

import java.util.Objects;

public class HashCodeExample {

    public static void main(String[] args) {

    }

    static class Student {
        int sno;
        String name;

        public Student(int sno, String name) {
            this.sno = sno;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sno, name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student student = (Student) obj;
                if (student.sno == this.sno) {
                    return student.name.equals(this.name);
                }
            }
            return false;
        }
    }
}
