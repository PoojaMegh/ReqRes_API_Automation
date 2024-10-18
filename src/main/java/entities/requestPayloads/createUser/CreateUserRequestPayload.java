package entities.requestPayloads.createUser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//POJO: Plain Old Java Object
@Getter
@Setter
@Builder

public class CreateUserRequestPayload {

        public String name;
        public String job;

}
