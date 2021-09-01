package com.crud.travelAgency.service;


import com.crud.travelAgency.domain.Hotel;
import com.crud.travelAgency.enumHotel.EnumHotel;
import com.crud.travelAgency.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public void saveHotel(final Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.getById(id);
    }

    public Hotel changeStandardHotel(Long hotelId, String standard) throws Exception  {

        Hotel hotel = hotelRepository.getById(hotelId);

        switch (standard) {
            case "LOW":
                hotel.setStandard(EnumHotel.LOW.getStandard());
                hotel.setPrice(EnumHotel.LOW.getPrice());
                break;
            case "MEDIUM":
                hotel.setStandard(EnumHotel.MEDIUM.getStandard());
                hotel.setPrice(EnumHotel.MEDIUM.getPrice());
                break;
            case "HIGH":
                hotel.setStandard(EnumHotel.HIGH.getStandard());
                hotel.setPrice(EnumHotel.HIGH.getPrice());
                break;
            default: throw new Exception();
        }
        return hotelRepository.save(hotel);
    }

    public void deleteHotelById(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
