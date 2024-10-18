package entities.responsePayloads.createUser;

import lombok.Getter;
import lombok.Setter;

//POJO: Plain Old Java Object
@Getter
public class CreateUserResponsePayload {
        public String name;
        public String job;
        public String id;
        public String createdAt;

}
