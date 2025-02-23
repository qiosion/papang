package co.company.papang.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookVO {
	private String cook_no;
	private String cook_title;
	private String mbr_id;
	private String cook_hit;
	private String cook_category;
	private String cook_content;
}
