-- liquibase formatted sql

-- changeset plusnin:001
CREATE TABLE "wallet" (
    "id" UUID,
    "balance" float not null
);