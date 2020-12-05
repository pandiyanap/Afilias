package com.afilias.friendsrelationship.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageRest<T> {

    private long limit;
    private long offset;
    private long total;
    private List<T> items;


}
