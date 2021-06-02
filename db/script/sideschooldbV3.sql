-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sideschooldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sideschooldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sideschooldb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema sideschooldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sideschooldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sideschooldb` DEFAULT CHARACTER SET utf8 ;
USE `sideschooldb` ;

-- -----------------------------------------------------
-- Table `sideschooldb`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`disciplina` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `disciplina` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`escola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`escola` (
  `id_escola` INT(11) NOT NULL AUTO_INCREMENT,
  `escola` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_escola`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`perfil` (
  `id_tipo_perfil` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_perfil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`perfil_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`perfil_usuario` (
  `user_id_login` INT(11) NOT NULL,
  `perfil_id_tipo_perfil` INT(11) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`turma` (
  `id_turma` INT(11) NOT NULL AUTO_INCREMENT,
  `id_escola` INT(11) NOT NULL,
  `nome_turma` VARCHAR(50) NOT NULL,
  `data_turma` DATE NOT NULL,
  PRIMARY KEY (`id_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`turma_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`turma_disciplina` (
  `turma_id_turma` INT(11) NOT NULL,
  `disciplina_id_disciplina` INT(11) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`usuario` (
  `id_login` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_login`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`aluno` (
  `id_aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `cpf` INT(11) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `situacao` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  UNIQUE INDEX `cpf` (`cpf` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`disciplina` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `disciplina` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_disciplina`),
  UNIQUE INDEX `id_disciplina` (`id_disciplina` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`atividade` (
  `id_atividade` INT(11) NOT NULL AUTO_INCREMENT,
  `id_disciplina` INT(11) NOT NULL,
  `enunciado` VARCHAR(255) NOT NULL,
  `data_atividade` DATETIME NOT NULL,
  PRIMARY KEY (`id_atividade`),
  UNIQUE INDEX `id_atividade` (`id_atividade` ASC) ,
  UNIQUE INDEX `id_disciplina` (`id_atividade` ASC, `id_disciplina` ASC) ,
  INDEX `FK_atividade` (`id_disciplina` ASC) ,
  CONSTRAINT `FK_atividade`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `sideschooldb`.`disciplina` (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`pergunta` (
  `id_pergunta` INT(11) NOT NULL AUTO_INCREMENT,
  `id_atividade` INT(11) NOT NULL,
  `enunciado` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pergunta`),
  UNIQUE INDEX `id_atividade_id_pergunta` (`id_atividade` ASC, `id_pergunta` ASC) ,
  CONSTRAINT `FK_pergunta`
    FOREIGN KEY (`id_atividade`)
    REFERENCES `sideschooldb`.`atividade` (`id_atividade`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`resposta` (
  `id_resposta` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pergunta` INT(11) NOT NULL,
  `resposta` VARCHAR(50) NOT NULL,
  `correta` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_resposta`),
  INDEX `FK_resposta` (`id_pergunta` ASC) ,
  CONSTRAINT `FK_resposta`
    FOREIGN KEY (`id_pergunta`)
    REFERENCES `sideschooldb`.`pergunta` (`id_pergunta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`aluno_resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`aluno_resposta` (
  `aluno_id_aluno` INT(11) NOT NULL,
  `resposta_id_resposta` INT(11) NOT NULL,
  `data_resposta` DATETIME NULL,
  INDEX `fk_table1_aluno_idx` (`aluno_id_aluno` ASC) ,
  INDEX `fk_table1_resposta1_idx` (`resposta_id_resposta` ASC) ,
  PRIMARY KEY (`aluno_id_aluno`, `resposta_id_resposta`),
  CONSTRAINT `fk_table1_aluno`
    FOREIGN KEY (`aluno_id_aluno`)
    REFERENCES `sideschooldb`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_resposta1`
    FOREIGN KEY (`resposta_id_resposta`)
    REFERENCES `sideschooldb`.`resposta` (`id_resposta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sideschooldb` ;

-- -----------------------------------------------------
-- Table `sideschooldb`.`escola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`escola` (
  `id_escola` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_escola` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_escola`),
  UNIQUE INDEX `nome_escola` (`nome_escola` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`turma` (
  `id_turma` INT(11) NOT NULL AUTO_INCREMENT,
  `id_escola` INT(11) NOT NULL,
  `nome_turma` VARCHAR(50) NOT NULL,
  `data_turma` DATE NOT NULL,
  PRIMARY KEY (`id_turma`),
  UNIQUE INDEX `nome_turma_id_escola` (`nome_turma` ASC, `id_escola` ASC) ,
  INDEX `FK_turma` (`id_escola` ASC) ,
  CONSTRAINT `FK_turma`
    FOREIGN KEY (`id_escola`)
    REFERENCES `sideschooldb`.`escola` (`id_escola`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`aluno_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`aluno_turma` (
  `id_aluno_turma` INT(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` INT(11) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  PRIMARY KEY (`id_aluno_turma`),
  UNIQUE INDEX `id_turma_id_aluno` (`id_aluno` ASC, `id_turma` ASC) ,
  INDEX `aluno_turma_id_turma` (`id_turma` ASC) ,
  CONSTRAINT `FK_aluno_id_aluno`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `sideschooldb`.`aluno` (`id_aluno`),
  CONSTRAINT `aluno_turma_id_turma`
    FOREIGN KEY (`id_turma`)
    REFERENCES `sideschooldb`.`turma` (`id_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`perfil` (
  `id_perfil` INT(11) NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB
CHECKSUM = 1
DEFAULT CHARACTER SET = utf8
DELAY_KEY_WRITE = 1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `sideschooldb`.`turma_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`turma_disciplina` (
  `id_turma` INT(11) NULL DEFAULT NULL,
  `id_disciplina` INT(11) NULL DEFAULT NULL,
  UNIQUE INDEX `FK_turma_disciplina` (`id_turma` ASC, `id_disciplina` ASC) ,
  INDEX `FK_turma_disciplina_id_disciplina` (`id_disciplina` ASC) ,
  CONSTRAINT `FK_turma_disciplina`
    FOREIGN KEY (`id_turma`)
    REFERENCES `sideschooldb`.`turma` (`id_turma`),
  CONSTRAINT `FK_turma_disciplina_id_disciplina`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `sideschooldb`.`disciplina` (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `login` (`login` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sideschooldb`.`usuario_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sideschooldb`.`usuario_perfil` (
  `id_usuario` INT(11) NOT NULL,
  `id_perfil` INT(11) NULL DEFAULT NULL,
  INDEX `FK_usuario_perfil` (`id_perfil` ASC) ,
  INDEX `FK_usuario_perfil_id_usuario` (`id_usuario` ASC) ,
  CONSTRAINT `FK_usuario_perfil`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `sideschooldb`.`perfil` (`id_perfil`),
  CONSTRAINT `FK_usuario_perfil_id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `sideschooldb`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
