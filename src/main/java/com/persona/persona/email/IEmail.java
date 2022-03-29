package com.persona.persona.email;

public interface IEmail {

    String getSubject();

    String getTo();

    IContent getContent();

}
