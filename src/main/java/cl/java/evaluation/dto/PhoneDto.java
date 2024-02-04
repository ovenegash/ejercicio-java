package cl.java.evaluation.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String citycode;
    private String countrycode;

}
