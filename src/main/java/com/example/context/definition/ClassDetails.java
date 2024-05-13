package com.example.context.definition;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClassDetails {

    @EqualsAndHashCode.Include
    private final String name;

    private final List<String> properties;
}
