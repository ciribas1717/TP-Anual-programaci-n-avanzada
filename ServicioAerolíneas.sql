USE [master]
GO
/****** Object:  Database [ServicioAerolíneas]    Script Date: 26/10/2019 16:48:38 ******/
CREATE DATABASE [ServicioAerolíneas]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ServicioAerolineas', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\ServicioAerolineas.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ServicioAerolineas_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\ServicioAerolineas_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ServicioAerolíneas] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ServicioAerolíneas].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ServicioAerolíneas] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET ARITHABORT OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ServicioAerolíneas] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ServicioAerolíneas] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ServicioAerolíneas] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ServicioAerolíneas] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ServicioAerolíneas] SET  MULTI_USER 
GO
ALTER DATABASE [ServicioAerolíneas] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ServicioAerolíneas] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ServicioAerolíneas] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ServicioAerolíneas] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ServicioAerolíneas] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ServicioAerolíneas] SET QUERY_STORE = OFF
GO
USE [ServicioAerolíneas]
GO
/****** Object:  Table [dbo].[Aeropuerto]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aeropuerto](
	[idAeropuerto] [int] IDENTITY(1,1) NOT NULL,
	[Código] [varchar](50) NULL,
	[Ciudad] [varchar](50) NULL,
	[idPaís] [int] NULL,
	[idProvincia] [int] NULL,
 CONSTRAINT [PK_Aeropuerto] PRIMARY KEY CLUSTERED 
(
	[idAeropuerto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Apellido] [varchar](50) NULL,
	[DNI] [varchar](50) NULL,
	[CUIT_CUIL] [varchar](50) NULL,
	[Fecha de nacimiento] [date] NULL,
	[Email] [varchar](50) NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dirección]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dirección](
	[idDirección] [int] IDENTITY(1,1) NOT NULL,
	[Calle] [varchar](50) NULL,
	[Altura] [varchar](50) NULL,
	[Ciudad] [varchar](50) NULL,
	[Código postal] [varchar](50) NULL,
	[idPaís] [int] NULL,
	[idProvincia] [int] NULL,
	[idCliente] [int] NULL,
 CONSTRAINT [PK_Dirección] PRIMARY KEY CLUSTERED 
(
	[idDirección] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LíneaAérea]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LíneaAérea](
	[idLíneaAérea] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Alianza] [varchar](50) NULL,
 CONSTRAINT [PK_LíneaAérea] PRIMARY KEY CLUSTERED 
(
	[idLíneaAérea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[País]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[País](
	[idPaís] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_País] PRIMARY KEY CLUSTERED 
(
	[idPaís] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PasajeroFrecuente]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PasajeroFrecuente](
	[idPasajeroFrecuente] [int] IDENTITY(1,1) NOT NULL,
	[Alianza] [varchar](50) NULL,
	[Número] [varchar](50) NULL,
	[Categoría] [varchar](50) NULL,
	[idCliente] [int] NULL,
	[idLíneaAérea] [int] NULL,
 CONSTRAINT [PK_PasajeroFrecuente] PRIMARY KEY CLUSTERED 
(
	[idPasajeroFrecuente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pasaporte]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pasaporte](
	[idPasaporte] [int] IDENTITY(1,1) NOT NULL,
	[Número] [varchar](50) NULL,
	[Autoridad] [varchar](50) NULL,
	[Fecha de emisión] [date] NULL,
	[Fecha de vencimiento] [date] NULL,
	[idPaís] [int] NULL,
	[idCliente] [int] NULL,
 CONSTRAINT [PK_Pasaporte] PRIMARY KEY CLUSTERED 
(
	[idPasaporte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Provincia]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Provincia](
	[idProvincia] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Provincia] PRIMARY KEY CLUSTERED 
(
	[idProvincia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teléfono]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teléfono](
	[idTeléfono] [int] IDENTITY(1,1) NOT NULL,
	[Número personal] [varchar](50) NULL,
	[Número celular] [varchar](50) NULL,
	[Número laboral] [varchar](50) NULL,
	[idCliente] [int] NULL,
 CONSTRAINT [PK_Teléfono] PRIMARY KEY CLUSTERED 
(
	[idTeléfono] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Venta]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venta](
	[idVenta] [int] IDENTITY(1,1) NOT NULL,
	[Fecha de venta] [datetime] NULL,
	[Forma de pago] [varchar](50) NULL,
	[idCliente] [int] NULL,
	[idVuelo] [int] NULL,
	[idLíneaAérea] [int] NULL,
 CONSTRAINT [PK_Venta] PRIMARY KEY CLUSTERED 
(
	[idVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vuelo]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vuelo](
	[idVuelo] [int] IDENTITY(1,1) NOT NULL,
	[Número] [varchar](50) NULL,
	[Cantidad de asientos] [int] NULL,
	[Fecha de salida] [datetime] NULL,
	[Fecha de llegada] [datetime] NULL,
	[Tiempo de vuelo] [int] NULL,
	[idAeropuertoSalida] [int] NULL,
	[idAeropuertoLlegada] [int] NULL,
	[idLíneaAérea] [int] NULL,
 CONSTRAINT [PK_Vuelo] PRIMARY KEY CLUSTERED 
(
	[idVuelo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Aeropuerto] ON 

INSERT [dbo].[Aeropuerto] ([idAeropuerto], [Código], [Ciudad], [idPaís], [idProvincia]) VALUES (1, N'1', N'1', 1, 1)
INSERT [dbo].[Aeropuerto] ([idAeropuerto], [Código], [Ciudad], [idPaís], [idProvincia]) VALUES (2, N'2', N'1', 1, 1)
SET IDENTITY_INSERT [dbo].[Aeropuerto] OFF
SET IDENTITY_INSERT [dbo].[Cliente] ON 

INSERT [dbo].[Cliente] ([idCliente], [Nombre], [Apellido], [DNI], [CUIT_CUIL], [Fecha de nacimiento], [Email]) VALUES (1, N'1', N'1', N'1', N'1', CAST(N'2000-01-01' AS Date), N'1')
INSERT [dbo].[Cliente] ([idCliente], [Nombre], [Apellido], [DNI], [CUIT_CUIL], [Fecha de nacimiento], [Email]) VALUES (2, N'Pedro', N'Perez', N'12345678', N'30-41235-678', CAST(N'2000-01-01' AS Date), N'1@a.com')
SET IDENTITY_INSERT [dbo].[Cliente] OFF
SET IDENTITY_INSERT [dbo].[Dirección] ON 

INSERT [dbo].[Dirección] ([idDirección], [Calle], [Altura], [Ciudad], [Código postal], [idPaís], [idProvincia], [idCliente]) VALUES (1, N'1', N'1', N'1', N'1', 1, 1, 1)
INSERT [dbo].[Dirección] ([idDirección], [Calle], [Altura], [Ciudad], [Código postal], [idPaís], [idProvincia], [idCliente]) VALUES (2, N'123', N'45', N'67', N'89', 9, 1, 2)
SET IDENTITY_INSERT [dbo].[Dirección] OFF
SET IDENTITY_INSERT [dbo].[LíneaAérea] ON 

INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (1, N'Aegean Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (2, N'Aeroflot Russian Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (3, N'Aerolíneas Argentinas', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (4, N'Aeromexico', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (5, N'Air Canada', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (6, N'Air China', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (7, N'Air Europa', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (8, N'Air France', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (9, N'Air India', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (10, N'Air New Zealand', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (11, N'Alitalia', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (12, N'All Nippon Airways', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (13, N'American Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (14, N'Asiana Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (15, N'Austrian Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (16, N'British Airways', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (17, N'Brussels Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (18, N'Cathay Pacific', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (19, N'China Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (20, N'China Eastern Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (21, N'China Southern Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (22, N'Croatia Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (23, N'Czech Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (24, N'Delta Air Lines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (25, N'Egyptair', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (26, N'Ethiopian Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (27, N'Eva Air', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (28, N'Finnair', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (29, N'Garuda Indonesia', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (30, N'Iberia', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (31, N'Japan Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (32, N'Kenya Airways', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (33, N'KLM Royal Dutch Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (34, N'Korean Air', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (35, N'LAN Colombia', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (36, N'LOT - Polish Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (37, N'Lufthansa', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (38, N'Malaysia Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (39, N'Middle East Airlines', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (40, N'Qantas Airways', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (41, N'Qatar Airways', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (42, N'Royal Jordanian', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (43, N'Scandinavian Airlines System (SAS)', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (44, N'Siberia Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (45, N'Singapore Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (46, N'South African Airways', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (47, N'Spanair', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (48, N'SriLankan Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (49, N'SWISS International Air Lines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (50, N'TAM Airlines', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (51, N'TAP Portugal', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (52, N'Tarom', N'SkyTeam')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (53, N'Thai Airways International', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (54, N'Turkish Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (55, N'United Airlines', N'Star Alliance')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (56, N'US Airways', N'Oneworld')
INSERT [dbo].[LíneaAérea] ([idLíneaAérea], [Nombre], [Alianza]) VALUES (57, N'Vietnam Airlines', N'SkyTeam')
SET IDENTITY_INSERT [dbo].[LíneaAérea] OFF
SET IDENTITY_INSERT [dbo].[País] ON 

INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (1, N'Afganistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (2, N'Albania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (3, N'Alemania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (4, N'Andorra')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (5, N'Angola')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (6, N'Antigua y Barbuda')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (7, N'Arabia Saudita')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (8, N'Argelia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (9, N'Argentina')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (10, N'Armenia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (11, N'Australia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (12, N'Austria')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (13, N'Azerbaiyán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (14, N'Bahamas')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (15, N'Bangladés')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (16, N'Barbados')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (17, N'Baréin')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (18, N'Bélgica')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (19, N'Belice')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (20, N'Benín')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (21, N'Bielorrusia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (22, N'Birmania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (23, N'Bolivia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (24, N'Bosnia y Herzegovina')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (25, N'Botsuana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (26, N'Brasil')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (27, N'Brunéi')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (28, N'Bulgaria')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (29, N'Burkina Faso')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (30, N'Burundi')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (31, N'Bután')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (32, N'Cabo Verde')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (33, N'Camboya')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (34, N'Camerún')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (35, N'Canadá')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (36, N'Catar')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (37, N'Chad')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (38, N'Chile')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (39, N'China')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (40, N'Chipre')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (41, N'Ciudad del Vaticano')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (42, N'Colombia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (43, N'Comoras')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (44, N'Corea del Norte')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (45, N'Corea del Sur')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (46, N'Costa de Marfil')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (47, N'Costa Rica')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (48, N'Croacia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (49, N'Cuba')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (50, N'Dinamarca')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (51, N'Dominica')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (52, N'Ecuador')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (53, N'Egipto')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (54, N'El Salvador')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (55, N'Emiratos Árabes Unidos')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (56, N'Eritrea')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (57, N'Eslovaquia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (58, N'Eslovenia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (59, N'España')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (60, N'Estados Unidos')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (61, N'Estonia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (62, N'Etiopía')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (63, N'Filipinas')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (64, N'Finlandia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (65, N'Fiyi')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (66, N'Francia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (67, N'Gabón')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (68, N'Gambia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (69, N'Georgia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (70, N'Ghana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (71, N'Granada')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (72, N'Grecia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (73, N'Guatemala')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (74, N'Guyana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (75, N'Guinea')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (76, N'Guinea-Bisáu')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (77, N'Guinea Ecuatorial')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (78, N'Haití')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (79, N'Honduras')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (80, N'Hungría')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (81, N'India')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (82, N'Indonesia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (83, N'Irak')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (84, N'Irán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (85, N'Irlanda')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (86, N'Islandia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (87, N'Islas Marshall')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (88, N'Islas Salomón')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (89, N'Israel')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (90, N'Italia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (91, N'Jamaica')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (92, N'Japón')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (93, N'Jordania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (94, N'Kazajistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (95, N'Kenia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (96, N'Kirguistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (97, N'Kiribati')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (98, N'Kuwait')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (99, N'Laos')
GO
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (100, N'Lesoto')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (101, N'Letonia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (102, N'Líbano')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (103, N'Liberia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (104, N'Libia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (105, N'Liechtenstein')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (106, N'Lituania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (107, N'Luxemburgo')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (108, N'Madagascar')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (109, N'Malasia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (110, N'Malaui')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (111, N'Maldivas')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (112, N'Malí')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (113, N'Malta')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (114, N'Marruecos')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (115, N'Mauricio')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (116, N'Mauritania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (117, N'México')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (118, N'Micronesia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (119, N'Moldavia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (120, N'Mónaco')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (121, N'Mongolia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (122, N'Montenegro')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (123, N'Mozambique')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (124, N'Namibia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (125, N'Nauru')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (126, N'Nepal')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (127, N'Nicaragua')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (128, N'Níger')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (129, N'Nigeria')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (130, N'Noruega')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (131, N'Nueva Zelanda')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (132, N'Omán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (133, N'Países Bajos')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (134, N'Pakistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (135, N'Palaos')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (136, N'Panamá')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (137, N'Papúa Nueva Guinea')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (138, N'Paraguay')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (139, N'Perú')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (140, N'Polonia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (141, N'Portugal')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (142, N'Reino Unido de Gran Bretaña e Irlanda del Norte')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (143, N'República Centroafricana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (144, N'República Checa')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (145, N'República de Macedonia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (146, N'República del Congo')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (147, N'República Democrática del Congo')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (148, N'República Dominicana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (149, N'República Sudafricana')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (150, N'Ruanda')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (151, N'Rumanía')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (152, N'Rusia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (153, N'Samoa')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (154, N'San Cristóbal y Nieves')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (155, N'San Marino')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (156, N'San Vicente y las Granadinas')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (157, N'Santa Lucía')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (158, N'Santo Tomé y Príncipe')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (159, N'Senegal')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (160, N'Serbia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (161, N'Seychelles')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (162, N'Sierra Leona')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (163, N'Singapur')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (164, N'Siria')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (165, N'Somalia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (166, N'Sri Lanka')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (167, N'Suazilandia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (168, N'Sudán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (169, N'Sudán del Sur')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (170, N'Suecia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (171, N'Suiza')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (172, N'Surinam')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (173, N'Tailandia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (174, N'Tanzania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (175, N'Tayikistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (176, N'Timor Oriental')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (177, N'Togo')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (178, N'Tonga')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (179, N'Trinidad y Tobago')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (180, N'Túnez')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (181, N'Turkmenistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (182, N'Turquía')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (183, N'Tuvalu')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (184, N'Ucrania')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (185, N'Uganda')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (186, N'Uruguay')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (187, N'Uzbekistán')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (188, N'Vanuatu')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (189, N'Venezuela')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (190, N'Vietnam')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (191, N'Yemen')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (192, N'Yibuti')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (193, N'Zambia')
INSERT [dbo].[País] ([idPaís], [Nombre]) VALUES (194, N'Zimbabue')
SET IDENTITY_INSERT [dbo].[País] OFF
SET IDENTITY_INSERT [dbo].[PasajeroFrecuente] ON 

INSERT [dbo].[PasajeroFrecuente] ([idPasajeroFrecuente], [Alianza], [Número], [Categoría], [idCliente], [idLíneaAérea]) VALUES (1, N'SkyTeam', N'1', N'1', 1, 1)
INSERT [dbo].[PasajeroFrecuente] ([idPasajeroFrecuente], [Alianza], [Número], [Categoría], [idCliente], [idLíneaAérea]) VALUES (2, N'SkyTeam', N'123-456', N'7', 2, 3)
SET IDENTITY_INSERT [dbo].[PasajeroFrecuente] OFF
SET IDENTITY_INSERT [dbo].[Pasaporte] ON 

INSERT [dbo].[Pasaporte] ([idPasaporte], [Número], [Autoridad], [Fecha de emisión], [Fecha de vencimiento], [idPaís], [idCliente]) VALUES (1, N'1', N'1', CAST(N'2000-01-01' AS Date), CAST(N'2000-02-01' AS Date), 1, 1)
INSERT [dbo].[Pasaporte] ([idPasaporte], [Número], [Autoridad], [Fecha de emisión], [Fecha de vencimiento], [idPaís], [idCliente]) VALUES (2, N'123-456', N'Jajaja', CAST(N'2000-01-01' AS Date), CAST(N'2000-01-01' AS Date), 9, 2)
SET IDENTITY_INSERT [dbo].[Pasaporte] OFF
SET IDENTITY_INSERT [dbo].[Provincia] ON 

INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (1, N'Buenos Aires')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (2, N'Catamarca')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (3, N'Chaco')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (4, N'Chubut')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (5, N'Córdoba')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (6, N'Corrientes')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (7, N'Entre Ríos')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (8, N'Formosa')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (9, N'Jujuy')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (10, N'La Pampa')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (11, N'La Rioja')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (12, N'Mendoza')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (13, N'Misiones')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (14, N'Neuquén')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (15, N'Río Negro')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (16, N'Salta')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (17, N'San Juan')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (18, N'San Luis')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (19, N'Santa Cruz')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (20, N'Santa Fe')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (21, N'Santiago del Estero')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (22, N'Tierra del Fuego')
INSERT [dbo].[Provincia] ([idProvincia], [Nombre]) VALUES (23, N'Tucumán')
SET IDENTITY_INSERT [dbo].[Provincia] OFF
SET IDENTITY_INSERT [dbo].[Teléfono] ON 

INSERT [dbo].[Teléfono] ([idTeléfono], [Número personal], [Número celular], [Número laboral], [idCliente]) VALUES (1, N'1', N'1', N'1', 1)
INSERT [dbo].[Teléfono] ([idTeléfono], [Número personal], [Número celular], [Número laboral], [idCliente]) VALUES (2, N'1', N'1', N'1', 2)
SET IDENTITY_INSERT [dbo].[Teléfono] OFF
SET IDENTITY_INSERT [dbo].[Venta] ON 

INSERT [dbo].[Venta] ([idVenta], [Fecha de venta], [Forma de pago], [idCliente], [idVuelo], [idLíneaAérea]) VALUES (5, CAST(N'2019-10-26T04:06:00.000' AS DateTime), N'Efectivo', 1, 1, 1)
INSERT [dbo].[Venta] ([idVenta], [Fecha de venta], [Forma de pago], [idCliente], [idVuelo], [idLíneaAérea]) VALUES (6, CAST(N'2019-10-26T16:32:00.000' AS DateTime), N'Efectivo', 1, 1, 1)
INSERT [dbo].[Venta] ([idVenta], [Fecha de venta], [Forma de pago], [idCliente], [idVuelo], [idLíneaAérea]) VALUES (7, CAST(N'2019-10-26T16:41:00.000' AS DateTime), N'Efectivo', 1, 1, 3)
SET IDENTITY_INSERT [dbo].[Venta] OFF
SET IDENTITY_INSERT [dbo].[Vuelo] ON 

INSERT [dbo].[Vuelo] ([idVuelo], [Número], [Cantidad de asientos], [Fecha de salida], [Fecha de llegada], [Tiempo de vuelo], [idAeropuertoSalida], [idAeropuertoLlegada], [idLíneaAérea]) VALUES (1, N'1234567', 700, CAST(N'2000-01-01T14:00:00.000' AS DateTime), CAST(N'2000-01-01T15:00:00.000' AS DateTime), 60, 1, 1, 1)
INSERT [dbo].[Vuelo] ([idVuelo], [Número], [Cantidad de asientos], [Fecha de salida], [Fecha de llegada], [Tiempo de vuelo], [idAeropuertoSalida], [idAeropuertoLlegada], [idLíneaAérea]) VALUES (2, N'123456789', 400, CAST(N'2000-01-01T14:00:00.000' AS DateTime), CAST(N'2000-01-01T15:50:00.000' AS DateTime), 110, 1, 1, 1)
INSERT [dbo].[Vuelo] ([idVuelo], [Número], [Cantidad de asientos], [Fecha de salida], [Fecha de llegada], [Tiempo de vuelo], [idAeropuertoSalida], [idAeropuertoLlegada], [idLíneaAérea]) VALUES (3, N'1', 1, CAST(N'2000-01-01T14:00:00.000' AS DateTime), CAST(N'2000-01-01T15:00:00.000' AS DateTime), 1, 1, 1, 1)
INSERT [dbo].[Vuelo] ([idVuelo], [Número], [Cantidad de asientos], [Fecha de salida], [Fecha de llegada], [Tiempo de vuelo], [idAeropuertoSalida], [idAeropuertoLlegada], [idLíneaAérea]) VALUES (4, N'1', 1, CAST(N'2000-01-01T14:00:00.000' AS DateTime), CAST(N'2000-01-01T15:00:00.000' AS DateTime), 1, 1, 1, 1)
INSERT [dbo].[Vuelo] ([idVuelo], [Número], [Cantidad de asientos], [Fecha de salida], [Fecha de llegada], [Tiempo de vuelo], [idAeropuertoSalida], [idAeropuertoLlegada], [idLíneaAérea]) VALUES (5, N'1', 1, CAST(N'2000-01-01T14:00:00.000' AS DateTime), CAST(N'2000-01-01T15:00:00.000' AS DateTime), 1, 1, 1, 1)
SET IDENTITY_INSERT [dbo].[Vuelo] OFF
ALTER TABLE [dbo].[Aeropuerto]  WITH CHECK ADD  CONSTRAINT [FK_Aeropuerto_País] FOREIGN KEY([idPaís])
REFERENCES [dbo].[País] ([idPaís])
GO
ALTER TABLE [dbo].[Aeropuerto] CHECK CONSTRAINT [FK_Aeropuerto_País]
GO
ALTER TABLE [dbo].[Aeropuerto]  WITH CHECK ADD  CONSTRAINT [FK_Aeropuerto_Provincia] FOREIGN KEY([idProvincia])
REFERENCES [dbo].[Provincia] ([idProvincia])
GO
ALTER TABLE [dbo].[Aeropuerto] CHECK CONSTRAINT [FK_Aeropuerto_Provincia]
GO
ALTER TABLE [dbo].[Dirección]  WITH CHECK ADD  CONSTRAINT [FK_Dirección_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Dirección] CHECK CONSTRAINT [FK_Dirección_Cliente]
GO
ALTER TABLE [dbo].[Dirección]  WITH CHECK ADD  CONSTRAINT [FK_Dirección_País] FOREIGN KEY([idPaís])
REFERENCES [dbo].[País] ([idPaís])
GO
ALTER TABLE [dbo].[Dirección] CHECK CONSTRAINT [FK_Dirección_País]
GO
ALTER TABLE [dbo].[Dirección]  WITH CHECK ADD  CONSTRAINT [FK_Dirección_Provincia] FOREIGN KEY([idProvincia])
REFERENCES [dbo].[Provincia] ([idProvincia])
GO
ALTER TABLE [dbo].[Dirección] CHECK CONSTRAINT [FK_Dirección_Provincia]
GO
ALTER TABLE [dbo].[PasajeroFrecuente]  WITH CHECK ADD  CONSTRAINT [FK_PasajeroFrecuente_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[PasajeroFrecuente] CHECK CONSTRAINT [FK_PasajeroFrecuente_Cliente]
GO
ALTER TABLE [dbo].[PasajeroFrecuente]  WITH CHECK ADD  CONSTRAINT [FK_PasajeroFrecuente_LíneaAérea] FOREIGN KEY([idLíneaAérea])
REFERENCES [dbo].[LíneaAérea] ([idLíneaAérea])
GO
ALTER TABLE [dbo].[PasajeroFrecuente] CHECK CONSTRAINT [FK_PasajeroFrecuente_LíneaAérea]
GO
ALTER TABLE [dbo].[Pasaporte]  WITH CHECK ADD  CONSTRAINT [FK_Pasaporte_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Pasaporte] CHECK CONSTRAINT [FK_Pasaporte_Cliente]
GO
ALTER TABLE [dbo].[Pasaporte]  WITH CHECK ADD  CONSTRAINT [FK_Pasaporte_País] FOREIGN KEY([idPaís])
REFERENCES [dbo].[País] ([idPaís])
GO
ALTER TABLE [dbo].[Pasaporte] CHECK CONSTRAINT [FK_Pasaporte_País]
GO
ALTER TABLE [dbo].[Teléfono]  WITH CHECK ADD  CONSTRAINT [FK_Teléfono_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Teléfono] CHECK CONSTRAINT [FK_Teléfono_Cliente]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Cliente]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_LíneaAérea] FOREIGN KEY([idLíneaAérea])
REFERENCES [dbo].[LíneaAérea] ([idLíneaAérea])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_LíneaAérea]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Vuelo] FOREIGN KEY([idVuelo])
REFERENCES [dbo].[Vuelo] ([idVuelo])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Vuelo]
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD  CONSTRAINT [FK_Vuelo_Aeropuerto] FOREIGN KEY([idAeropuertoSalida])
REFERENCES [dbo].[Aeropuerto] ([idAeropuerto])
GO
ALTER TABLE [dbo].[Vuelo] CHECK CONSTRAINT [FK_Vuelo_Aeropuerto]
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD  CONSTRAINT [FK_Vuelo_Aeropuerto1] FOREIGN KEY([idAeropuertoLlegada])
REFERENCES [dbo].[Aeropuerto] ([idAeropuerto])
GO
ALTER TABLE [dbo].[Vuelo] CHECK CONSTRAINT [FK_Vuelo_Aeropuerto1]
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD  CONSTRAINT [FK_Vuelo_LíneaAérea] FOREIGN KEY([idLíneaAérea])
REFERENCES [dbo].[LíneaAérea] ([idLíneaAérea])
GO
ALTER TABLE [dbo].[Vuelo] CHECK CONSTRAINT [FK_Vuelo_LíneaAérea]
GO
/****** Object:  StoredProcedure [dbo].[CLIENTEABM]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CLIENTEABM] @TIPO VARCHAR(50), @NOMBRE VARCHAR(50), @APELLIDO VARCHAR(50), @DNI VARCHAR(50), @NÚMEROPASAPORTE VARCHAR(50), @AUTORIDAD VARCHAR(50), @FECEMISIÓN DATE,
@FECVENC DATE, @NOMBREPAÍSPASAPORTE VARCHAR(50), @CUITCUIL VARCHAR(50), @FECNAC DATE, @EMAIL VARCHAR(50), @NÚMEROPERSONAL VARCHAR(50), @NÚMEROCELULAR VARCHAR(50),
@NÚMEROLABORAL VARCHAR(50), @ALIANZA VARCHAR(50), @NÚMEROPASAJERO VARCHAR(50), @CATEGORÍAPASAJERO VARCHAR(50), @NOMBREAEROLÍNEA VARCHAR(50), @CALLE VARCHAR(50), @ALTURA VARCHAR(50),
@CIUDAD VARCHAR(50), @CÓDIGOPOSTAL VARCHAR(50), @NOMBREPAÍSDIRECCIÓN VARCHAR(50), @NOMBREPROVINCIA VARCHAR(50), @IDCLIENTEBM INT

AS
DECLARE @IDCLIENTE AS INT
DECLARE @IDPAÍSDIRECCIÓN AS INT
DECLARE @IDPAÍSPASAPORTE AS INT
DECLARE @IDPROVINCIA AS INT
DECLARE @IDLÍNEAAÉREA AS INT

IF (@TIPO = 'ALTA')
BEGIN

INSERT INTO Cliente VALUES (@NOMBRE, @APELLIDO, @DNI, @CUITCUIL, @FECNAC, @EMAIL)
SET @IDCLIENTE = SCOPE_IDENTITY()

INSERT INTO Teléfono VALUES (@NÚMEROPERSONAL, @NÚMEROCELULAR, @NÚMEROLABORAL, @IDCLIENTE)

SELECT @IDPAÍSDIRECCIÓN = País.idPaís FROM País WHERE País.Nombre = @NOMBREPAÍSDIRECCIÓN
SELECT @IDPROVINCIA = Provincia.idProvincia FROM Provincia WHERE Provincia.Nombre = @NOMBREPROVINCIA
INSERT INTO Dirección VALUES (@CALLE, @ALTURA, @CIUDAD, @CÓDIGOPOSTAL, @IDPAÍSDIRECCIÓN, @IDPROVINCIA, @IDCLIENTE)

SELECT @IDPAÍSPASAPORTE = País.idPaís FROM País WHERE País.Nombre = @NOMBREPAÍSPASAPORTE
INSERT INTO Pasaporte VALUES (@NÚMEROPASAPORTE, @AUTORIDAD, @FECEMISIÓN, @FECVENC, @IDPAÍSPASAPORTE, @IDCLIENTE)

SELECT @IDLÍNEAAÉREA = LíneaAérea.idLíneaAérea FROM LíneaAérea WHERE LíneaAérea.Nombre = @NOMBREAEROLÍNEA
INSERT INTO PasajeroFrecuente VALUES (@ALIANZA, @NÚMEROPASAJERO, @CATEGORÍAPASAJERO, @IDCLIENTE, @IDLÍNEAAÉREA)

END

ELSE IF (@TIPO = 'BAJA')
BEGIN

DELETE FROM DIRECCIÓN WHERE Dirección.idCliente = @IDCLIENTEBM
DELETE FROM PasajeroFrecuente WHERE PasajeroFrecuente.idCliente = @IDCLIENTEBM
DELETE FROM Teléfono WHERE Teléfono.idCliente = @IDCLIENTEBM
DELETE FROM Pasaporte WHERE Pasaporte.idCliente = @IDCLIENTEBM
DELETE FROM Cliente WHERE Cliente.idCliente = @IDCLIENTEBM

END

ELSE IF (@TIPO = 'MODIFICACIÓN')
BEGIN

UPDATE Cliente SET Nombre = @NOMBRE, Apellido = @APELLIDO, DNI = @DNI, CUIT_CUIL = @CUITCUIL, [Fecha de nacimiento] = @FECNAC, Email = @EMAIL WHERE Cliente.idCliente = @IDCLIENTEBM
SELECT @IDPAÍSDIRECCIÓN = País.idPaís FROM País WHERE País.Nombre = @NOMBREPAÍSDIRECCIÓN
SELECT @IDPROVINCIA = Provincia.idProvincia FROM Provincia WHERE Provincia.Nombre = @NOMBREPROVINCIA
UPDATE Dirección SET Calle = @CALLE, Altura = @ALTURA, Ciudad = @CIUDAD, [Código postal] = @CÓDIGOPOSTAL, idPaís = @IDPAÍSDIRECCIÓN, idProvincia = @IDPROVINCIA
WHERE Dirección.idCliente = @IDCLIENTEBM

UPDATE Teléfono SET [Número personal] = @NÚMEROPERSONAL, [Número celular] = @NÚMEROCELULAR, [Número laboral] = @NÚMEROLABORAL
WHERE Teléfono.idCliente = @IDCLIENTEBM

SELECT @IDPAÍSPASAPORTE = País.idPaís FROM País WHERE País.Nombre = @NOMBREPAÍSPASAPORTE
UPDATE Pasaporte SET Número = @NÚMEROPASAPORTE, Autoridad = @AUTORIDAD, [Fecha de emisión] = @FECEMISIÓN, [Fecha de vencimiento] = @FECVENC, idPaís = @IDPAÍSPASAPORTE
WHERE Pasaporte.idCliente = @IDCLIENTEBM

SELECT @IDLÍNEAAÉREA = LíneaAérea.idLíneaAérea FROM LíneaAérea WHERE LíneaAérea.Nombre = @NOMBREAEROLÍNEA
UPDATE PasajeroFrecuente SET Alianza = @ALIANZA, Número = @NÚMEROPASAJERO, Categoría = @CATEGORÍAPASAJERO, idLíneaAérea = @IDLÍNEAAÉREA
WHERE PasajeroFrecuente.idCliente = @IDCLIENTEBM

END

ELSE IF (@TIPO = 'CONSULTA')
BEGIN

SELECT Cliente.idCliente, CLIENTE.NOMBRE AS 'NOMBRE CLIENTE', APELLIDO, DNI, Pasaporte.idPasaporte, PASAPORTE.[Número] AS 'NÚMERO DE PASAPORTE', P.NOMBRE AS 'NOMBRE PAÍS', AUTORIDAD, [Fecha de emisión], [Fecha de vencimiento], CUIT_CUIL, [Fecha de nacimiento], Email, Teléfono.idTeléfono, [Número personal],
[Número celular], [Número laboral], PasajeroFrecuente.idPasajeroFrecuente, PASAJEROFRECUENTE.ALIANZA AS 'ALIANZA', PasajeroFrecuente.idLíneaAérea, LÍNEAAÉREA.NOMBRE AS 'NOMBRE LÍNEA AÉREA', PASAJEROFRECUENTE.Número AS 'NÚMERO DE PASAJERO FRECUENTE', CATEGORÍA, Dirección.idDirección, CALLE, ALTURA,
CIUDAD, G.NOMBRE AS 'NOMBRE PAÍS DE LA PROVINCIA', T.NOMBRE AS 'PROVINCIA', [Código postal]
FROM CLIENTE
INNER JOIN PASAPORTE ON Pasaporte.idCliente = @IDCLIENTEBM
INNER JOIN PAÍS P ON PASAPORTE.IDPAÍS = P.IDPAÍS
INNER JOIN TELÉFONO ON Teléfono.idCliente = Cliente.idCliente
INNER JOIN PASAJEROFRECUENTE ON PasajeroFrecuente.idCliente = Cliente.idCliente
INNER JOIN LÍNEAAÉREA ON PASAJEROFRECUENTE.IDLÍNEAAÉREA = LÍNEAAÉREA.IDLÍNEAAÉREA
INNER JOIN DIRECCIÓN ON CLIENTE.idCliente = DIRECCIÓN.idCliente
INNER JOIN PAÍS G ON DIRECCIÓN.IDPAÍS = G.IDPAÍS
INNER JOIN PROVINCIA T ON DIRECCIÓN.IDPROVINCIA = T.idProvincia
WHERE CLIENTE.idCliente = @IDCLIENTEBM

END

ELSE IF (@TIPO = 'CONSULTATOTAL')
BEGIN
SELECT Cliente.idCliente, CLIENTE.NOMBRE AS 'NOMBRE CLIENTE', APELLIDO, DNI, Pasaporte.idPasaporte, PASAPORTE.[Número] AS 'NÚMERO DE PASAPORTE', P.NOMBRE AS 'NOMBRE PAÍS', AUTORIDAD, [Fecha de emisión], [Fecha de vencimiento], CUIT_CUIL, [Fecha de nacimiento], Email, Teléfono.idTeléfono, [Número personal],
[Número celular], [Número laboral], PasajeroFrecuente.idPasajeroFrecuente, PASAJEROFRECUENTE.ALIANZA AS 'ALIANZA', PasajeroFrecuente.idLíneaAérea, LÍNEAAÉREA.NOMBRE AS 'NOMBRE LÍNEA AÉREA', PASAJEROFRECUENTE.Número AS 'NÚMERO DE PASAJERO FRECUENTE', CATEGORÍA, Dirección.idDirección, CALLE, ALTURA,
CIUDAD, G.NOMBRE AS 'NOMBRE PAÍS DE LA PROVINCIA', T.NOMBRE AS 'PROVINCIA', [Código postal]
FROM CLIENTE
INNER JOIN PASAPORTE ON Pasaporte.idCliente = Cliente.idCliente
INNER JOIN PAÍS P ON PASAPORTE.IDPAÍS = P.IDPAÍS
INNER JOIN TELÉFONO ON Teléfono.idCliente = Cliente.idCliente
INNER JOIN PASAJEROFRECUENTE ON PasajeroFrecuente.idCliente = Cliente.idCliente
INNER JOIN LÍNEAAÉREA ON PASAJEROFRECUENTE.IDLÍNEAAÉREA = LÍNEAAÉREA.IDLÍNEAAÉREA
INNER JOIN DIRECCIÓN ON CLIENTE.idCliente = DIRECCIÓN.idCliente
INNER JOIN PAÍS G ON DIRECCIÓN.IDPAÍS = G.IDPAÍS
INNER JOIN PROVINCIA T ON DIRECCIÓN.IDPROVINCIA = T.idProvincia

END

GO
/****** Object:  StoredProcedure [dbo].[VENTAABM]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[VENTAABM] @TIPO VARCHAR(50), @FECVENTA DATETIME, @FORMADEPAGO VARCHAR(50), @DNICLIENTE VARCHAR(50), @NÚMERODEVUELO VARCHAR(50),
@NOMBREAEROLÍNEA VARCHAR(50), @IDVENTA INT

AS
DECLARE @IDCLIENTE INT
DECLARE @IDVUELO INT
DECLARE @IDLÍNEAAÉREA INT

SELECT @IDCLIENTE = Cliente.idCliente FROM Cliente WHERE Cliente.DNI = @DNICLIENTE
SELECT @IDVUELO = Vuelo.idVuelo FROM Vuelo WHERE Vuelo.Número = @NÚMERODEVUELO
SELECT @IDLÍNEAAÉREA = LíneaAérea.idLíneaAérea FROM LíneaAérea WHERE LíneaAérea.Nombre = @NOMBREAEROLÍNEA

IF (@TIPO = 'ALTA')

INSERT INTO Venta VALUES (@FECVENTA, @FORMADEPAGO, @IDCLIENTE, @IDVUELO, @IDLÍNEAAÉREA)

ELSE IF (@TIPO = 'BAJA')

DELETE FROM Venta WHERE Venta.idVenta = @IDVENTA

ELSE IF (@TIPO = 'MODIFICACIÓN')

UPDATE Venta SET [Forma de pago] = @FORMADEPAGO, idCliente = @IDCLIENTE, idVuelo = @IDVUELO, idLíneaAérea = @IDLÍNEAAÉREA WHERE Venta.idVenta = @IDVENTA

ELSE IF (@TIPO = 'CONSULTA')

SELECT Venta.idVenta, Venta.[Fecha de venta], Venta.[Forma de pago], Venta.idCliente, Cliente.Nombre, Cliente.Apellido, Cliente.DNI, Cliente.CUIT_CUIL, Cliente.[Fecha de nacimiento], Cliente.Email,
Venta.idVuelo, Vuelo.Número, Vuelo.[Cantidad de asientos], Vuelo.[Fecha de salida], Vuelo.[Fecha de llegada], Vuelo.[Tiempo de vuelo], Vuelo.idAeropuertoSalida, ASAL.Código, ASAL.CIUDAD, P.NOMBRE, G.NOMBRE, Vuelo.idAeropuertoLlegada,
AL.Código, AL.CIUDAD, ALPAÍS.NOMBRE, ALPROVINCIA.NOMBRE,
Venta.idLíneaAérea, LíneaAérea.Nombre, LíneaAérea.Alianza
FROM VENTA
INNER JOIN CLIENTE ON Venta.idCliente = Cliente.idCliente
INNER JOIN VUELO ON Venta.idVuelo = Vuelo.idVuelo
INNER JOIN Aeropuerto ASAL ON Vuelo.idAeropuertoSalida = ASAL.idAeropuerto
INNER JOIN País P ON ASAL.idPaís = P.idPaís
INNER JOIN Provincia G ON ASAL.idProvincia = G.idProvincia
INNER JOIN Aeropuerto AL ON Vuelo.idAeropuertoLlegada = AL.idAeropuerto
INNER JOIN País ALPAÍS ON AL.idPaís = ALPAÍS.idPaís
INNER JOIN Provincia ALPROVINCIA ON ALPROVINCIA.idProvincia = AL.idProvincia
INNER JOIN LÍNEAAÉREA ON Venta.idLíneaAérea = LíneaAérea.idLíneaAérea
WHERE Venta.idVenta = @IDVENTA

ELSE IF (@TIPO = 'CONSULTATOTAL')

SELECT Venta.idVenta, Venta.[Fecha de venta], Venta.[Forma de pago], Venta.idCliente, Cliente.Nombre, Cliente.Apellido, Cliente.DNI, Cliente.CUIT_CUIL, Cliente.[Fecha de nacimiento], Cliente.Email,
Venta.idVuelo, Vuelo.Número, Vuelo.[Cantidad de asientos], Vuelo.[Fecha de salida], Vuelo.[Fecha de llegada], Vuelo.[Tiempo de vuelo], Vuelo.idAeropuertoSalida, ASAL.Código, ASAL.CIUDAD, P.NOMBRE, G.NOMBRE, Vuelo.idAeropuertoLlegada,
AL.Código, AL.CIUDAD, ALPAÍS.NOMBRE, ALPROVINCIA.NOMBRE,
Venta.idLíneaAérea, LíneaAérea.Nombre, LíneaAérea.Alianza
FROM VENTA
INNER JOIN CLIENTE ON Venta.idCliente = Cliente.idCliente
INNER JOIN VUELO ON Venta.idVuelo = Vuelo.idVuelo
INNER JOIN Aeropuerto ASAL ON Vuelo.idAeropuertoSalida = ASAL.idAeropuerto
INNER JOIN País P ON ASAL.idPaís = P.idPaís
INNER JOIN Provincia G ON ASAL.idProvincia = G.idProvincia
INNER JOIN Aeropuerto AL ON Vuelo.idAeropuertoLlegada = AL.idAeropuerto
INNER JOIN País ALPAÍS ON AL.idPaís = ALPAÍS.idPaís
INNER JOIN Provincia ALPROVINCIA ON ALPROVINCIA.idProvincia = AL.idProvincia
INNER JOIN LÍNEAAÉREA ON Venta.idLíneaAérea = LíneaAérea.idLíneaAérea
GO
/****** Object:  StoredProcedure [dbo].[VUELOABM]    Script Date: 26/10/2019 16:48:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[VUELOABM] @TIPO VARCHAR(50), @NÚMEROVUELO VARCHAR(50), @CANTASIENTOS INT, @FECSALIDA DATETIME, @FECLLEGADA DATETIME, @TIEMPOVUELO INT,
@CÓDIGOAEROPUERTOSALIDA VARCHAR(50), @CÓDIGOAEROPUERTOLLEGADA VARCHAR(50), @NOMBRELÍNEAAÉREA VARCHAR(50), @IDVUELO INT

AS

DECLARE @IDAEROPUERTOSALIDA INT
DECLARE @IDAEROPUERTOLLEGADA INT
DECLARE @IDLÍNEAAÉREA INT

IF (@TIPO = 'ALTA')

BEGIN

SELECT @IDAEROPUERTOSALIDA = Aeropuerto.idAeropuerto FROM Aeropuerto WHERE Aeropuerto.Código = @CÓDIGOAEROPUERTOSALIDA
SELECT @IDAEROPUERTOLLEGADA = Aeropuerto.idAeropuerto FROM Aeropuerto WHERE Aeropuerto.Código = @CÓDIGOAEROPUERTOLLEGADA
SELECT @IDLÍNEAAÉREA = LíneaAérea.idLíneaAérea FROM LíneaAérea WHERE LíneaAérea.Nombre = @NOMBRELÍNEAAÉREA

INSERT INTO Vuelo VALUES (@NÚMEROVUELO, @CANTASIENTOS, @FECSALIDA, @FECLLEGADA, @TIEMPOVUELO, @IDAEROPUERTOSALIDA, @IDAEROPUERTOLLEGADA, @IDLÍNEAAÉREA)

END

ELSE IF (@TIPO = 'BAJA')

BEGIN

DELETE FROM Vuelo WHERE Vuelo.idVuelo = @IDVUELO

END

ELSE IF (@TIPO = 'MODIFICACIÓN')

BEGIN

SELECT @IDAEROPUERTOSALIDA = Aeropuerto.idAeropuerto FROM Aeropuerto WHERE Aeropuerto.Código = @CÓDIGOAEROPUERTOSALIDA
SELECT @IDAEROPUERTOLLEGADA = Aeropuerto.idAeropuerto FROM Aeropuerto WHERE Aeropuerto.Código = @CÓDIGOAEROPUERTOLLEGADA
SELECT @IDLÍNEAAÉREA = LíneaAérea.idLíneaAérea FROM LíneaAérea WHERE LíneaAérea.Nombre = @NOMBRELÍNEAAÉREA

UPDATE Vuelo SET Número = @NÚMEROVUELO, [Cantidad de asientos] = @CANTASIENTOS, [Fecha de salida] = @FECSALIDA, [Fecha de llegada] = @FECLLEGADA,
[Tiempo de vuelo] = @TIEMPOVUELO, idAeropuertoSalida = @IDAEROPUERTOSALIDA, idAeropuertoLlegada = @IDAEROPUERTOLLEGADA, idLíneaAérea = @IDLÍNEAAÉREA WHERE
Vuelo.idVuelo = @IDVUELO

END

ELSE IF (@TIPO = 'CONSULTA')

BEGIN

SELECT Vuelo.idVuelo AS 'ID Vuelo', Vuelo.Número AS 'NÚMERO DE VUELO', Vuelo.[Cantidad de asientos], Vuelo.[Fecha de salida], Vuelo.[Fecha de llegada]
, Vuelo.[Tiempo de vuelo], Vuelo.idAeropuertoSalida, ASAL.Código, ASAL.Ciudad, P.Nombre AS 'PAÍS AEROPUERTO SALIDA', G.NOMBRE AS 'PROVINCIA AEROPUERTO SALIDA', Vuelo.idAeropuertoLlegada, AL.CÓDIGO
, AL.CIUDAD, ALPAÍS.NOMBRE AS 'PAÍS AEROPUERTO LLEGADA', ALPROVINCIA.NOMBRE AS 'PROVINCIA AEROPUERTO LLEGADA', Vuelo.idLíneaAérea, LíneaAérea.Nombre, LíneaAérea.Alianza
FROM Vuelo
INNER JOIN Aeropuerto ASAL ON Vuelo.idAeropuertoSalida = ASAL.idAeropuerto
INNER JOIN PAÍS P ON ASAL.idPaís = P.IDPAÍS
INNER JOIN Provincia G ON ASAL.idProvincia = G.idProvincia
INNER JOIN Aeropuerto AL ON Vuelo.idAeropuertoLlegada = AL.idAeropuerto
INNER JOIN País ALPAÍS ON AL.idPaís = ALPAÍS.idPaís
INNER JOIN Provincia ALPROVINCIA ON AL.idProvincia = ALPROVINCIA.idProvincia
INNER JOIN LíneaAérea ON LíneaAérea.idLíneaAérea = Vuelo.idLíneaAérea
WHERE Vuelo.idVuelo = @IDVUELO

END

ELSE IF (@TIPO = 'CONSULTATOTAL')

BEGIN

SELECT Vuelo.idVuelo AS 'ID Vuelo', Vuelo.Número AS 'NÚMERO DE VUELO', Vuelo.[Cantidad de asientos], Vuelo.[Fecha de salida], Vuelo.[Fecha de llegada]
, Vuelo.[Tiempo de vuelo], Vuelo.idAeropuertoSalida, ASAL.Código, ASAL.Ciudad, P.Nombre AS 'PAÍS AEROPUERTO SALIDA', G.NOMBRE AS 'PROVINCIA AEROPUERTO SALIDA', Vuelo.idAeropuertoLlegada, AL.CÓDIGO
, AL.CIUDAD, ALPAÍS.NOMBRE AS 'PAÍS AEROPUERTO LLEGADA', ALPROVINCIA.NOMBRE AS 'PROVINCIA AEROPUERTO LLEGADA', Vuelo.idLíneaAérea, LíneaAérea.Nombre, LíneaAérea.Alianza
FROM Vuelo
INNER JOIN Aeropuerto ASAL ON Vuelo.idAeropuertoSalida = ASAL.idAeropuerto
INNER JOIN PAÍS P ON ASAL.idPaís = P.IDPAÍS
INNER JOIN Provincia G ON ASAL.idProvincia = G.idProvincia
INNER JOIN Aeropuerto AL ON Vuelo.idAeropuertoLlegada = AL.idAeropuerto
INNER JOIN País ALPAÍS ON AL.idPaís = ALPAÍS.idPaís
INNER JOIN Provincia ALPROVINCIA ON AL.idProvincia = ALPROVINCIA.idProvincia
INNER JOIN LíneaAérea ON LíneaAérea.idLíneaAérea = Vuelo.idLíneaAérea

END

GO
USE [master]
GO
ALTER DATABASE [ServicioAerolíneas] SET  READ_WRITE 
GO
