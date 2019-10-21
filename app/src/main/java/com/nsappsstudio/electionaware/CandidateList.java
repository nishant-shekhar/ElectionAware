package com.nsappsstudio.electionaware;

public class CandidateList {

    public String name;
    public String partyName;
    public String qualification;

    public CandidateList(String name, String partyName, String qualification) {
        this.name = name;
        this.partyName = partyName;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getQualification() {
        return qualification;
    }
}
