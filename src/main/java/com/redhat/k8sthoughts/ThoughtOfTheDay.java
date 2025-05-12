package com.redhat.k8sthoughts;

import java.time.LocalDate;

public record ThoughtOfTheDay(
    String thought,
    String author,
    LocalDate day
) {} 