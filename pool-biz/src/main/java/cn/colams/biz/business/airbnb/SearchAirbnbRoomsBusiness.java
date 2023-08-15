package cn.colams.biz.business.airbnb;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.model.dto.airbnb.SearchAirbnbRoomsParams;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class SearchAirbnbRoomsBusiness {

    @Autowired
    private AirbnbExtensionMapper airbnbExtensionMapper;

    public SearchResultWithPage<List<Airbnb>> searchAirbnbRooms(SearchAirbnbRoomsParams data) throws ParseException {
        SearchResultWithPage<List<Airbnb>> result = airbnbExtensionMapper.searchAirbnbRooms(data);
        return result;
    }
}
