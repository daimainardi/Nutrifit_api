CREATE TABLE consultas(
    id bigint not null auto_increment,
    paciente_id bigint not null,
    nutricionista_id bigint not null,
    motivo_da_consulta varchar(250) not null,

    primary key(id),
    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id),
    constraint fk_consultas_nutricionista_id foreign key(nutricionista_id) references nutricionistas(id)
);
