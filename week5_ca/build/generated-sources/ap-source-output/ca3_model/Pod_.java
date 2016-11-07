package ca3_model;

import ca3_model.delivery;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T18:40:36")
@StaticMetamodel(Pod.class)
public class Pod_ { 

    public static volatile SingularAttribute<Pod, Date> date;
    public static volatile SingularAttribute<Pod, String> note;
    public static volatile SingularAttribute<Pod, byte[]> image;
    public static volatile SingularAttribute<Pod, Integer> ackid;
    public static volatile SingularAttribute<Pod, delivery> delivery;
    public static volatile SingularAttribute<Pod, Integer> podid;

}