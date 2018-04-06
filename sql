USE [GESHUM]
GO
/****** Object:  StoredProcedure [Nomina].[USP_SEL_M_Sede_001]    Script Date: 06/04/2018 01:51:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


ALTER PROCEDURE [Nomina].[USP_SEL_M_Sede_001]
@DesSede varchar(50) 
AS
-- =============================================
-- Author:		Patricia Joyo
-- Create date: 04/04/2018
-- Description:	Listado de Sedes
-- =============================================
BEGIN
	SET NOCOUNT ON;

	select s.IdeSede,s.ideEmpr,s.CodSede,s.DesSede,s.EstDomiFisc,s.IdeSedeRtps,sr.DesSedeRtps,
	s.NumRucSede,s.IdeTipoCasa,t.DesTipoCasa,s.IdeVias,v.DesVias,s.DirSede,s.NroCasa,s.NroInte,
	s.IdeZona,z.DesZona,s.NomZona,s.DesRefe,s.NroFruc,s.EstCrie,s.ImpCrie,s.IdeUbicGeog,u.CodUbicGeog
	from GESHUM.Nomina.M_Sede s
	join GESHUM.Nomina.Vis_Vias v on s.IdeVias= v.IdeVias
	join GESHUM.Nomina.Vis_Zona z on s.IdeZona=z.IdeZona
	join GESHUM.Nomina.Vis_M_UbicGeog u on s.IdeUbicGeog=u.IdeUbicGeog
	join GESHUM.Nomina.Vis_SedesRtps sr on s.IdeSedeRtps=sr.IdeSedeRtps
	join GESHUM.Nomina.Vis_TipoCasa t on s.IdeTipoCasa =t.IdeTipoCasa
	where 
	((@DesSede != '' AND s.DesSede LIKE '%'+ @DesSede + '%') OR (@DesSede = ''))

END

exec [Nomina].[USP_SEL_M_Sede_002] ''

USE [GESHUM]
GO
/****** Object:  StoredProcedure [Nomina].[USP_SEL_M_Sede_001]    Script Date: 06/04/2018 01:51:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


alter PROCEDURE [Nomina].[USP_SEL_M_Sede_002]
@DesSede varchar(50) 
AS
-- =============================================
-- Author:		Patricia Joyo
-- Create date: 04/04/2018
-- Description:	Listado de Sedes
-- =============================================
BEGIN
	SET NOCOUNT ON;

	select s.IdeSede,s.ideEmpr,s.CodSede,s.DesSede,s.EstDomiFisc,s.IdeSedeRtps,v.DesRegi,
	s.NumRucSede,s.IdeTipoCasa,t.DesRegi,s.IdeVias,v.DesRegi,s.DirSede,s.NroCasa,s.NroInte,
	s.IdeZona,z.DesRegi,s.NomZona,s.DesRefe,s.NroFruc,s.EstCrie,s.ImpCrie,s.IdeUbicGeog,u.CodUbicGeog
	from GESHUM.Nomina.M_Sede s
	join GESHUM.Nomina.M_ConfInfoCorp v on s.IdeVias=v.ideInfCorp
	join GESHUM.Nomina.M_ConfInfoCorp z on s.IdeZona=z.ideInfCorp
	join GESHUM.Nomina.M_ConfInfoCorp sr on s.IdeSedeRtps=sr.ideInfCorp
	join GESHUM.Nomina.M_ConfInfoCorp t on s.IdeTipoCasa=t.ideInfCorp
	join  CONFIG.Seguridad.M_UbicGeog  u on s.IdeUbicGeog=u.IdeUbicGeog
	where 
	((@DesSede != '' AND s.DesSede LIKE '%'+ @DesSede + '%') OR (@DesSede = ''))

END
