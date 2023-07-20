package API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyArgs<T> {
    @Builder.Default
    private String jsonrpc="2.0";
    @Builder.Default
    private int id=1518863034;
    public String method;
    public T params;
}
