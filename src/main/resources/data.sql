INSERT into KNOWLEDGE
values (1, 'Some knowledge title 1', 'some knowledge description 1', STR_TO_DATE('11-08-2022', '%d-%m-%Y')),
       (2, 'Some knowledge title 2', 'some knowledge description 2', STR_TO_DATE('11-08-2022', '%d-%m-%Y')),
       (3, 'Some knowledge title 3', 'some knowledge description 3', STR_TO_DATE('13-08-2022', '%d-%m-%Y')),
       (4, 'Some knowledge title 4', 'some knowledge description 4', STR_TO_DATE('13-08-2022', '%d-%m-%Y')),
       (5, 'Some knowledge title 5', 'some knowledge description 5', STR_TO_DATE('13-08-2022', '%d-%m-%Y')),
       (6, 'Some knowledge title 6', 'some knowledge description 6', STR_TO_DATE('13-08-2022', '%d-%m-%Y')),
       (7, 'Some knowledge title 7', 'some knowledge description 7', STR_TO_DATE('13-08-2022', '%d-%m-%Y'));

insert into PACKAGE
values (1, 'Some Package title 1'),
       (2, 'Some Package title 2'),
       (3, 'Some Package title 3'),
       (4, 'Some Package title 4'),
       (5, 'Some Package title 5'),
       (6, 'Some Package title 6');

insert into  KNOWLEDGE_PACKAGE
values (1,1),
       (2,1),
       (3,1),
       (1,2),
       (2,2),
       (2,3),
       (3,3),
       (4,3),
       (5,3),
       (1,4),
       (2,4),
       (3,5),
       (4,5),
       (6,6);