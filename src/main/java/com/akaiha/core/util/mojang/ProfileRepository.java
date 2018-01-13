package com.akaiha.core.util.mojang;

public interface ProfileRepository {
    public Profile[] findProfilesByNames(String... names);
}
