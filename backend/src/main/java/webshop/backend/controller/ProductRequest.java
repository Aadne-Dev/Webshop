package webshop.backend.controller;

public record ProductRequest(
        String productname,
        Integer price
) {}
