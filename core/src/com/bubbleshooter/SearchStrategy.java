package com.bubbleshooter;

import java.util.Set;

public interface SearchStrategy {
    Set<Bubble> search(Bubble start);
}
