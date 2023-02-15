package com.emailer.fields;

public class Fields {
    private int id;
    private String subject;
    private String html;
    private String To;

    private String plain;
    public Fields(){

    }
    public Fields(String To, String subject, String html, String plain){
        this.subject = subject;
        this.html = html;
        this.To = To;
        this.plain = plain;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id =id;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getHtml(){
        return html;
    }
    public void setHtml(String html){
        this.html = html;
    }
    public String getTo(){
        return To;
    }
    public void setTo(String To){
        this.To = To;
    }
    public String getPlain(){
        return plain;
    }
    public void setPlain(String plain){
        this.plain = plain;
    }
}

