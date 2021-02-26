package com.springboot.restful.utilities;

import java.util.List;

public interface ConvertDaoAndDto<entity,Dto> {
    entity convertDTOtoEntity(Dto dto);
    List<Dto> convertEntitiesToDTOs(List<entity> entity);
}
