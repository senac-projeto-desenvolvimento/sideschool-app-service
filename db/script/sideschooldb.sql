/*
SQLyog Enterprise - MySQL GUI v6.52
MySQL - 5.7.33-google-log : Database - sideschooldb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `sideschooldb`;

USE `sideschooldb`;

/*Table structure for table `aluno` */

DROP TABLE IF EXISTS `aluno`;

CREATE TABLE `aluno` (
  `id_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` int(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `situacao` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `aluno` */

/*Table structure for table `aluno_turma` */

DROP TABLE IF EXISTS `aluno_turma`;

CREATE TABLE `aluno_turma` (
  `id_aluno_turma` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  PRIMARY KEY (`id_aluno_turma`),
  UNIQUE KEY `id_turma_id_aluno` (`id_aluno`,`id_turma`),
  KEY `aluno_turma_id_turma` (`id_turma`),
  CONSTRAINT `FK_aluno_id_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`),
  CONSTRAINT `aluno_turma_id_turma` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `aluno_turma` */

/*Table structure for table `atividade` */

DROP TABLE IF EXISTS `atividade`;

CREATE TABLE `atividade` (
  `id_atividade` int(11) NOT NULL AUTO_INCREMENT,
  `id_disciplina` int(11) NOT NULL,
  `enunciado` varchar(255) NOT NULL,
  `data_atividade` datetime NOT NULL,
  PRIMARY KEY (`id_atividade`),
  UNIQUE KEY `id_atividade` (`id_atividade`),
  UNIQUE KEY `id_disciplina` (`id_atividade`,`id_disciplina`),
  KEY `FK_atividade` (`id_disciplina`),
  CONSTRAINT `FK_atividade` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `atividade` */

insert  into `atividade`(`id_atividade`,`id_disciplina`,`enunciado`,`data_atividade`) values (1,1,'Tarefa de matematica I','2021-05-10 19:22:56');

/*Table structure for table `disciplina` */

DROP TABLE IF EXISTS `disciplina`;

CREATE TABLE `disciplina` (
  `id_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `disciplina` varchar(30) NOT NULL,
  PRIMARY KEY (`id_disciplina`),
  UNIQUE KEY `id_disciplina` (`id_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `disciplina` */

insert  into `disciplina`(`id_disciplina`,`disciplina`) values (1,'Matemática');

/*Table structure for table `escola` */

DROP TABLE IF EXISTS `escola`;

CREATE TABLE `escola` (
  `id_escola` int(11) NOT NULL AUTO_INCREMENT,
  `nome_escola` varchar(255) NOT NULL,
  PRIMARY KEY (`id_escola`),
  UNIQUE KEY `nome_escola` (`nome_escola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `escola` */

/*Table structure for table `perfil` */

DROP TABLE IF EXISTS `perfil`;

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `perfil` */

/*Table structure for table `pergunta` */

DROP TABLE IF EXISTS `pergunta`;

CREATE TABLE `pergunta` (
  `id_pergunta` int(11) NOT NULL AUTO_INCREMENT,
  `id_atividade` int(11) NOT NULL,
  `enunciado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pergunta`),
  UNIQUE KEY `id_atividade_id_pergunta` (`id_atividade`,`id_pergunta`),
  CONSTRAINT `FK_pergunta` FOREIGN KEY (`id_atividade`) REFERENCES `atividade` (`id_atividade`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pergunta` */

insert  into `pergunta`(`id_pergunta`,`id_atividade`,`enunciado`) values (1,1,'Quanto é 1 + 1?');

/*Table structure for table `resposta` */

DROP TABLE IF EXISTS `resposta`;

CREATE TABLE `resposta` (
  `id_resposta` int(11) NOT NULL AUTO_INCREMENT,
  `id_pergunta` int(11) NOT NULL,
  `resposta` varchar(50) NOT NULL,
  `correta` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_resposta`),
  KEY `FK_resposta` (`id_pergunta`),
  CONSTRAINT `FK_resposta` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id_pergunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resposta` */

/*Table structure for table `turma` */

DROP TABLE IF EXISTS `turma`;

CREATE TABLE `turma` (
  `id_turma` int(11) NOT NULL AUTO_INCREMENT,
  `id_escola` int(11) NOT NULL,
  `nome_turma` varchar(50) NOT NULL,
  `data_turma` date NOT NULL,
  PRIMARY KEY (`id_turma`),
  UNIQUE KEY `nome_turma_id_escola` (`nome_turma`,`id_escola`),
  KEY `FK_turma` (`id_escola`),
  CONSTRAINT `FK_turma` FOREIGN KEY (`id_escola`) REFERENCES `escola` (`id_escola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `turma` */

/*Table structure for table `turma_disciplina` */

DROP TABLE IF EXISTS `turma_disciplina`;

CREATE TABLE `turma_disciplina` (
  `id_turma` int(11) DEFAULT NULL,
  `id_disciplina` int(11) DEFAULT NULL,
  UNIQUE KEY `FK_turma_disciplina` (`id_turma`,`id_disciplina`),
  KEY `FK_turma_disciplina_id_disciplina` (`id_disciplina`),
  CONSTRAINT `FK_turma_disciplina` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FK_turma_disciplina_id_disciplina` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `turma_disciplina` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`id_usuario`,`login`,`nome`,`senha`) values (1,'teste','Usuario Teste','teste');

/*Table structure for table `usuario_perfil` */

DROP TABLE IF EXISTS `usuario_perfil`;

CREATE TABLE `usuario_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) DEFAULT NULL,
  KEY `FK_usuario_perfil` (`id_perfil`),
  KEY `FK_usuario_perfil_id_usuario` (`id_usuario`),
  CONSTRAINT `FK_usuario_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`),
  CONSTRAINT `FK_usuario_perfil_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario_perfil` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
