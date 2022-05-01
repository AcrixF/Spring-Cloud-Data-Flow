package org.neoa.ch03.movieweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    private String title;
    private String actor;
    private int year;

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Movie(title: ");
        builder.append(title);
        builder.append(", actor: ");
        builder.append(actor);
        builder.append(", year: ");
        builder.append(year);
        builder.append(")");
        return builder.toString();
    }

}
