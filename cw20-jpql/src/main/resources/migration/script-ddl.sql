CREATE TABLE CATEGORIES (
    ID              UUID PRIMARY KEY NOT NULL,
    NAME            VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE COURSES (
    ID              UUID PRIMARY KEY NOT NULL,
    NAME            VARCHAR(100) NOT NULL UNIQUE,
    COST            INTEGER NOT NULL,
    CATEGORY_ID     UUID NOT NULL REFERENCES CATEGORIES (ID)
);

CREATE TABLE STUDENTS (
    ID      UUID PRIMARY KEY NOT NULL,
    NAME    VARCHAR(20) NOT NULL

);

CREATE TABLE CONTACTS (
    ID          UUID PRIMARY KEY NOT NULL,
    VALUE       VARCHAR(70) NOT NULL,
    TYPE        VARCHAR(15) NOT NULL CHECK (TYPE IN ('PHONE', 'EMAIL', 'TELEGRAM')),
    STUDENT_ID  UUID NOT NULL REFERENCES STUDENTS (ID),
    UNIQUE (TYPE, STUDENT_ID)
);

CREATE TABLE STUDENTS_COURSES (
    STUDENT_ID      UUID NOT NULL REFERENCES STUDENTS (ID),
    COURSE_ID       UUID NOT NULL REFERENCES COURSES (ID)
);