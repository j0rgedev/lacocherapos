package view.components.alert;

import lombok.Data;

@Data
public class AlertModel {
    private ErrorType errorType;
    private String title;
    private String description;
}

