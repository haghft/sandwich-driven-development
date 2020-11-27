package use_case;

import model.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;

public class FakeRecruiters implements RecruiterRepository {

    List<Recruiter> recruiters;

    @Override
    public Recruiter bookAvailability(Recruiter appropriateRecruiter, LocalDate availability) {
        recruiters.forEach(recruiter -> {
            if (recruiter.getRecruiterId().equals(appropriateRecruiter.getRecruiterId())) {
                recruiter.getAvailabilities().remove(availability);
            }
        });
        return findRecruiterById(appropriateRecruiter.getRecruiterId());
    }

    @Override
    public List<Recruiter> findAllRecruiters() {
        return recruiters;
    }

    public Recruiter findRecruiterById(String recruiterId) {
        return recruiters.stream()
                .filter(recruiter -> recruiter.getRecruiterId().contains(recruiterId))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);
    }

    public FakeRecruiters() {
        recruiters = new ArrayList<>();

        Recruiter emma = new Recruiter();
        emma.setRecruiterId("001");
        List<String> emmaSkills = new ArrayList<>();
        emmaSkills.add("PHP");
        emmaSkills.add("JS");
        emma.setSkills(emmaSkills);
        emma.setName("Emma");
        List<LocalDate> emmaAvailabilities = new ArrayList<>();
        emmaAvailabilities.add(of(2021, 2, 20));
        emma.setAvailabilities(emmaAvailabilities);
        recruiters.add(emma);

        Recruiter mary = new Recruiter();
        mary.setRecruiterId("002");
        List<String> marySkills = new ArrayList<>();
        marySkills.add("Java");
        marySkills.add(".Net");
        marySkills.add("PHP");
        marySkills.add("JS");
        mary.setSkills(marySkills);
        mary.setName("Mary");
        List<LocalDate> maryAvailabilities = new ArrayList<>();
        maryAvailabilities.add(of(2021, 2, 20));
        maryAvailabilities.add(of(2021, 2, 22));
        mary.setAvailabilities(maryAvailabilities);
        recruiters.add(mary);

        Recruiter john = new Recruiter();
        john.setRecruiterId("003");
        List<String> johnSkills = new ArrayList<>();
        johnSkills.add("Java");
        johnSkills.add(".Net");
        johnSkills.add("PHP");
        johnSkills.add("JS");
        john.setSkills(johnSkills);
        john.setName("John");
        List<LocalDate> johnAvailabilities = new ArrayList<>();
        johnAvailabilities.add(of(2021, 2, 20));
        john.setAvailabilities(johnAvailabilities);
        recruiters.add(john);
    }
}
