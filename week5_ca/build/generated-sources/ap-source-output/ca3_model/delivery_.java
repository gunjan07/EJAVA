package ca3_model;

import ca3_model.Pod;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T18:40:36")
@StaticMetamodel(delivery.class)
public class delivery_ { 

    public static volatile SingularAttribute<delivery, Date> date;
    public static volatile SingularAttribute<delivery, String> address;
    public static volatile SingularAttribute<delivery, Pod> pod;
    public static volatile SingularAttribute<delivery, String> phone;
    public static volatile SingularAttribute<delivery, String> name;
    public static volatile SingularAttribute<delivery, Integer> pkgid;

}