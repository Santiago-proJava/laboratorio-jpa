package com.example.models;

import com.example.models.Producto;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-05T19:23:19")
@StaticMetamodel(Competitor.class)
public class Competitor_ { 

    public static volatile SingularAttribute<Competitor, String> country;
    public static volatile SingularAttribute<Competitor, String> address;
    public static volatile SingularAttribute<Competitor, String> city;
    public static volatile SingularAttribute<Competitor, String> telephone;
    public static volatile SingularAttribute<Competitor, Calendar> createdAt;
    public static volatile SingularAttribute<Competitor, String> password;
    public static volatile SingularAttribute<Competitor, Boolean> winner;
    public static volatile SingularAttribute<Competitor, String> surname;
    public static volatile SingularAttribute<Competitor, String> name;
    public static volatile SingularAttribute<Competitor, String> cellphone;
    public static volatile SingularAttribute<Competitor, Long> id;
    public static volatile ListAttribute<Competitor, Producto> productos;
    public static volatile SingularAttribute<Competitor, Integer> age;
    public static volatile SingularAttribute<Competitor, Calendar> updatedAt;

}