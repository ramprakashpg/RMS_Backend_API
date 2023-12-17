package org.rms.rms_backend_api.model;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Review {
    String review_id;
    String reviewer;
    String movie;
    String rating;
    String review_summary;
    String review_date;
    String spoiler_tag;
    String review_detail;
    List<String> helpful;
}

