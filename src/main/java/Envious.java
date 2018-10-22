public class Envious {

    public void methodOVeruse(Donor donor) {
        String res = donor.s1 + donor.s2 + donor.s3 + donor.s4 + donor.s5 + donor.s6 + donor.s7;
        donor.setS1(res);
        donor.setS2(res);
        donor.setS3(res);
        donor.setS4(res);
        donor.setS5(res);
        donor.setS6(res);
        donor.setS7(res);
    }
}
