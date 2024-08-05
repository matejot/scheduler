package ironhack.com.scheduler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sites")


public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int siteId;
    private String siteName;
//    private String availability_zone;

//    public Site (int siteId, String siteName){
//        this.siteId = siteId;
//        this.siteName = siteName;
//    }
}
