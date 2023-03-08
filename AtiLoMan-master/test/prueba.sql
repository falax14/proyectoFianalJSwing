
/* Creamos los indices */
DROP INDEX IF EXISTS `turno_detail_FKIndex1` ON `turno_detail`;
CREATE INDEX IF NOT EXISTS `turno_detail_FKIndex1` ON `turno_detail` (
    `turno_master_id`
    );
DROP INDEX IF EXISTS `calendario_festivo_FKIndex1` ON `calendario_festivo`;
CREATE INDEX IF NOT EXISTS `calendario_festivo_FKIndex1` ON `calendario_festivo` (
    `centro_fisico_id`
    );
DROP INDEX IF EXISTS `ciclo_detail_FKIndex1` ON `ciclo_detail`;
CREATE INDEX IF NOT EXISTS `ciclo_detail_FKIndex1` ON `ciclo_detail` (
    `ciclo_master_id`
    );
DROP INDEX IF EXISTS `ciclo_detail_FKIndex2` ON `ciclo_detail`;
CREATE INDEX IF NOT EXISTS `ciclo_detail_FKIndex2` ON `ciclo_detail` (
    `turno_master_id`
    );
DROP INDEX IF EXISTS `estructura_FKIndex3` ON `estructura`;
CREATE INDEX IF NOT EXISTS `estructura_FKIndex3` ON `estructura` (
    `categoria_id`
    );
DROP INDEX IF EXISTS `estructura_FKIndex2` ON `estructura`;
CREATE INDEX IF NOT EXISTS `estructura_FKIndex2` ON `estructura` (
    `centro_fisico_id`
    );
DROP INDEX IF EXISTS `estructura_FKIndex1` ON `estructura`;
CREATE INDEX IF NOT EXISTS `estructura_FKIndex1` ON `estructura` (
    `servicio_id`
    );
DROP INDEX IF EXISTS `estructura_FKIndex4` ON `estructura`;
CREATE INDEX IF NOT EXISTS `estructura_FKIndex4` ON `estructura` (
    `puesto_id`
    );
DROP INDEX IF EXISTS `unit_FKIndex1` ON `unit`;
CREATE INDEX IF NOT EXISTS `unit_FKIndex1` ON `unit` (
    `tipo_unit_id`
    );
DROP INDEX IF EXISTS `jornada_teorica_FKIndex1` ON `jornada_teorica`;
CREATE INDEX IF NOT EXISTS `jornada_teorica_FKIndex1` ON `jornada_teorica` (
    `centro_fisico_id`
    );
DROP INDEX IF EXISTS `servicios_previos_FKIndex1` ON `servicios_previos`;
CREATE INDEX IF NOT EXISTS `servicios_previos_FKIndex1` ON `servicios_previos` (
    `persona_id`
    );
DROP INDEX IF EXISTS `cambio_turno_FKIndex1` ON `cambio_turno`;
CREATE INDEX IF NOT EXISTS `cambio_turno_FKIndex1` ON `cambio_turno` (
    `tarea_id`
    );
DROP INDEX IF EXISTS `cobertura_equipo_FKIndex1` ON `cobertura_equipo`;
CREATE INDEX IF NOT EXISTS `cobertura_equipo_FKIndex1` ON `cobertura_equipo` (
    `categoria_id`
    );
DROP INDEX IF EXISTS `usuario_estructura_FKIndex2` ON `usuario_estructura`;
CREATE INDEX IF NOT EXISTS `usuario_estructura_FKIndex2` ON `usuario_estructura` (
    `usuario_id`
    );


DROP VIEW IF EXISTS `v_planificacion`;
CREATE VIEW v_planificacion AS
select dia, turno, anno, mes, categoria_id equipo_id, tarea_id
from (select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      1 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia1 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      1 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-01' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia1
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      2 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia2 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      2 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-02' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia2
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      3 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia3 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      3 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-03' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia3
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      4 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia4 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      4 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-04' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia4
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      5 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia5 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      5 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-05' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia5

      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      6 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia6 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      6 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-06' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia6
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      7 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia7 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      7 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-07' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia7
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      8 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia8 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      8 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-08' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia8
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      9 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia9 end                                                                              turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      9 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-09' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia9
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      10 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia10 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      10 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-10' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia10
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      11 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia11 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      11 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-11' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia11
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      12 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia12 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      12 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-12' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia12
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      13 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia13 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      13 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-13' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia13
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      14 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia14 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      14 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-14' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia14
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      15 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia15 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      15 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-15' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia15
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      16 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia16 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      16 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-16' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia16
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      17 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia17 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      17 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-17' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia17
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      18 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia18 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      18 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-18' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia18
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      19 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia19 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      19 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-19' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia19
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      20 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia20 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      20 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-20' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia20
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      21 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia21 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      21 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-21' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia21
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      22 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia22 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      22 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-22' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia22
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      23 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia23 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      23 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-23' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia23
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      24 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia24 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      24 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-24' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia24
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      25 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia25 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      25 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-25' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia25
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      26 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia26 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      26 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-26' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia26
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      27 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia27 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      27 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-27' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia27
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      28 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia28 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      28 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-28' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia28
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      29 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia29 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      29 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-29' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia29
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      30 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia30 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      30 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-30' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia30
      union all
      select case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      31 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then dia31 end                                                                             turno,
             mes,
             categoria_id,
             anno,
             tarea.id                                                                                           tarea_id,
             case
                 when mes between cast(MONTH(tarea.fecha_inicio) as integer) and cast(MONTH(tarea.fecha_fin) as integer) and
                      31 between cast(DAY(tarea.fecha_inicio) as integer) and cast(DAY(tarea.fecha_fin) as integer)
                     then planificacion.anno || '-' ||
                          substr('00' || planificacion.mes, length('00' || planificacion.mes) - 1) || '-31' end dia
      from planificacion
               join estructura on estructura.puesto_id = planificacion.puesto_id
               join tarea on tarea.puesto_id = planificacion.puesto_id
               join turno_master t1 on t1.codigo = planificacion.dia31) as p
where turno is not null;

DROP VIEW IF EXISTS v_diario;
CREATE VIEW v_diario as
select cf_id,
       sf_id,
       eq_id,
       p_id,
       persona_id,
       dni,
       dia,
       turno,
       descripcion,
       case when dif_horas_0_0 is null then dif_horas_0_1 else dif_horas_0_0 end horas,
       case when dif_min_0_1 is null then dif_min_0_0 else dif_min_0_1 end       minutos
from (select p.cf_id,
             p.sf_id,
             p.eq_id,
             p.p_id,
             persona_id,
             dni,
             dia,
             turno,
             turno_master.descripcion,
             turno_detail.dia_inicial,
             turno_detail.dia_final,
             turno_detail.hora_inicio,
             turno_detail.hora_fin,
             case
                 when turno_detail.dia_inicial = turno_detail.dia_final then
                     cast(((DATE_FORMAT('2017-01-01 ' || turno_detail.hora_fin, '%s') -
                            DATE_FORMAT('2017-01-01 ' || turno_detail.hora_inicio, '%s')) % (60 * 60 * 24)) /
                          (60 * 60) as integer)
                 else null end dif_horas_0_0,
             case
                 when turno_detail.dia_inicial = turno_detail.dia_final then
                     cast(((DATE_FORMAT('2017-01-01 ' || turno_detail.hora_fin, '%s') -
                            DATE_FORMAT('2017-01-01 ' || turno_detail.hora_inicio, '%s')) % (60 * 60 * 24)) %
                          (60 * 60) /
                          60 as integer)
                 else null end dif_min_0_0,

             case
                 when turno_detail.dia_inicial = 0 and turno_detail.dia_final = 1 then
                     (cast(((DATE_FORMAT('2017-01-01 24:00', '%s') -
                             DATE_FORMAT('2017-01-01 ' || turno_detail.hora_inicio, '%s')) % (60 * 60 * 24)) /
                           (60 * 60) as integer) +
                      cast(((DATE_FORMAT('2017-01-01 ' || turno_detail.hora_fin, '%s') -
                             DATE_FORMAT('2017-01-01 00:00', '%s')) % (60 * 60 * 24)) / (60 * 60) as integer))
                 else null end dif_horas_0_1,

             case
                 when turno_detail.dia_inicial = 0 and turno_detail.dia_final = 1 then
                     (cast(((DATE_FORMAT('2017-01-01 24:00', '%s') -
                             DATE_FORMAT('2017-01-01 ' || turno_detail.hora_inicio, '%s')) % (60 * 60 * 24)) %
                           (60 * 60) /
                           60 as integer) +
                      cast(((DATE_FORMAT('2017-01-01 ' || turno_detail.hora_fin, '%s') -
                             DATE_FORMAT('2017-01-01 00:00', '%s')) % (60 * 60 * 24)) % (60 * 60) / 60 as integer))
                 else null end dif_min_0_1
      from (select v_planificacion.dia,
                   coalesce(cambio_turno.turno_modificado, v_planificacion.turno) turno,
                   persona.id                                                     persona_id,
                   persona.dni,
                   estructura.centro_fisico_id                                    cf_id,
                   estructura.servicio_id                                         sf_id,
                   estructura.categoria_id                                        eq_id,
                   estructura.puesto_id                                           p_id
            from tarea
                     join contrato on contrato.id = tarea.contrato_id
                     join persona on persona.id = contrato.persona_id
                     join estructura on estructura.puesto_id = tarea.puesto_id
                     join v_planificacion on v_planificacion.equipo_id = estructura.categoria_id
                and v_planificacion.tarea_id = tarea.id
                     left join cambio_turno on cambio_turno.tarea_id = v_planificacion.tarea_id
                and cambio_turno.dia = v_planificacion.dia) p
               join turno_master on turno_master.codigo = p.turno
               join turno_detail on turno_detail.turno_master_id = turno_master.id) as ptmtd
group by persona_id, dni, dia, turno, descripcion, cf_id, sf_id, eq_id, p_id;

DROP VIEW IF EXISTS v_ausencia;
CREATE VIEW v_ausencia AS
select anno,
       anno_devengo,
       estado_devengo,
       case
           when horas_turno = 0 then 0.0
           when horas_ausencia >= horas_turno then horas_turno
           else horas_ausencia end,
       horas_ausencia,
       cod_aus,
       desc_aus,
       fini_aus,
       ffin_aus,
       ausencia_parcial,
       hora_inicio,
       hora_fin,
       aus_id,
       aus_cuenta_horas,
       aus_cuenta_dias,
       turno,
       horas_turno,
       fecha,
       persona_id,
       tarea_id,
       contrato_id
from (select DATE_FORMAT(contrato_ausencia.fecha_inicio, '%Y')                                           anno,
             contrato_ausencia.anno_devengo                                                              anno_devengo,
             ausencia.estado_devengo,
             case
                 when contrato_ausencia.ausencia_parcial = 'S' then cast((
                         DATE_FORMAT('2017-01-01 ' || contrato_ausencia.hora_fin, '%s') -
                         DATE_FORMAT('2017-01-01 ' || contrato_ausencia.hora_inicio, '%s')) as float)
                 when contrato_ausencia.ausencia_parcial = 'N'
                     then cast((v_diario.horas * 60 * 60) + (v_diario.minutos * 60) as float) end / 3600 horas_ausencia,
             cast((v_diario.horas * 60 * 60) + (v_diario.minutos * 60) as float) / 3600                  horas_turno,
             contrato_ausencia.ausencia_parcial,
             contrato_ausencia.hora_inicio,
             contrato_ausencia.hora_fin,
             tarea.id                                                                                    tarea_id,
             contrato.id                                                                                 contrato_id,
             v_diario.turno,
             v_diario.dia                                                                                fecha,
             contrato_ausencia.fecha_inicio                                                              fini_aus,
             contrato_ausencia.fecha_fin                                                                 ffin_aus,
             persona.id                                                                                  persona_id,
             ausencia.id                                                                                 aus_id,
             ausencia.codigo                                                                             cod_aus,
             ausencia.descripcion                                                                        desc_aus,
             ausencia.cuenta_horas                                                                       aus_cuenta_horas,
             ausencia.cuenta_dias                                                                        aus_cuenta_dias
      from estructura
               join tarea on tarea.puesto_id = estructura.puesto_id
               join contrato on contrato.id = tarea.contrato_id
               join persona on persona.id = contrato.persona_id
               join v_diario on v_diario.persona_id = contrato.persona_id
               join turno_master on turno_master.codigo = v_diario.turno
               join contrato_ausencia on contrato_ausencia.contrato_id = contrato.id
          and v_diario.dia between contrato_ausencia.fecha_inicio and contrato_ausencia.fecha_fin
               join ausencia on ausencia.id = contrato_ausencia.ausencia_id) as etcpvdtmcaa;

DROP VIEW IF EXISTS v_balance;
CREATE VIEW v_balance AS
select cf_id,
       sf_id,
       eq_id,
       p_id,
       dia,
       persona_id,
       dni,
       nombre,
       apellidos,
       sp,
       horas_turno - horas_ausencia horas_presencia,
       anno_ausencia,
       devengo_ausencia,
       estado_devengo
from (select v_diario.dia,
             v_diario.cf_id,
             v_diario.sf_id,
             v_diario.eq_id,
             v_diario.p_id,
             persona.id                                                                    persona_id,
             persona.dni,
             persona.nombre,
             persona.apellidos,
             coalesce(0, servicios_previos.horas)                                          sp,
             cast(v_diario.horas as float) + (cast(v_diario.minutos as float) / 60)        horas_turno,
             case
                 when v_ausencia.aus_cuenta_horas = 'S' or v_ausencia.aus_cuenta_horas is null then 0
                 when v_ausencia.aus_cuenta_horas = 'N' then v_ausencia.horas_ausencia end horas_ausencia,
             v_ausencia.anno                                                               anno_ausencia,
             v_ausencia.anno_devengo                                                       devengo_ausencia,
             v_ausencia.estado_devengo
      from v_diario
               join persona on persona.id = v_diario.persona_id
               left join servicios_previos on servicios_previos.persona_id = v_diario.persona_id
               left join v_ausencia on v_ausencia.persona_id = v_diario.persona_id
          and v_ausencia.fecha = v_diario.dia) as vdpspva;




