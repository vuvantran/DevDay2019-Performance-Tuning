package com.axonactive.devdayapp.service;

import java.util.List;
import com.axonactive.devdayapp.dto.BookDto;

public interface ExternalService {

    List<BookDto> search(String keyword);

}

