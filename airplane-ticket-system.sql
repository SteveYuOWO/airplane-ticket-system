-- airplane ticket system
-- date : 2020.01.08
-- author: steve yu

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
	[uid] CHAR(36) NOT NULL PRIMARY KEY,
	[username] VARCHAR(50) not null,
	[sex] CHAR(1) default 'M' check ([sex] in ('M','F')),
	[age] INT,
	[identity_num] VARCHAR(20),
	[level] INT,
	[score] INT,
	[address] VARCHAR(255),
	[mobile_num] VARCHAR(15),
	[password] CHAR(32) NOT NULL,
);
DROP TABLE IF EXISTS t_company;
CREATE TABLE t_company(
	ccid CHAR(36) NOT NULL PRIMARY KEY,
	[name] VARCHAR(50),
	[description] VARCHAR(255),
	[address] VARCHAR(255)
)

DROP TABLE IF EXISTS t_plane;
CREATE TABLE t_plane(
	ppid CHAR(36) NOT NULL PRIMARY KEY,
	[type] VARCHAR(50),
	seat_num INT,
	tourist_num INT,
	business_num INT,
	place VARCHAR(50),
	cid CHAR(36) FOREIGN KEY REFERENCES t_company(ccid)
)

DROP TABLE IF EXISTS t_airline;
CREATE TABLE t_airline(
	alid CHAR(36) NOT NULL PRIMARY KEY,
	startPlace VARCHAR(50),
	arrivePlace VARCHAR(50),
	ppid CHAR(36) FOREIGN KEY REFERENCES t_plane(ppid)
)

DROP TABLE IF EXISTS t_airflight;
CREATE TABLE t_airflight(
	afid VARCHAR (36) NOT NULL PRIMARY KEY,
	start_time DATETIME,
	arrive_time DATETIME,
	tourist_price DECIMAL(10,2),
	first_price DECIMAL(10,2),
	business_price DECIMAL(10,2),
	alid CHAR(36) FOREIGN KEY REFERENCES t_airline(alid)
)

ALTER TABLE t_airflight ADD CONSTRAINT ck_airflight check (afid like 'G[0-9][0-9][0-9][0-9]')

DROP TABLE IF EXISTS t_ticket;
CREATE TABLE t_ticket(
	tid CHAR(36) NOT NULL PRIMARY KEY,
	purchase_time DATETIME,
	seat_num INT,
	[uid] CHAR(36) FOREIGN KEY REFERENCES t_user([uid]),
	afid VARCHAR (36) FOREIGN KEY REFERENCES t_airflight(afid),
);

-- for index page select convenient
CREATE VIEW today_ticket_simple as
    select today_airflight.afid afid,
           T.start_place start_place,
           T.arrive_place arrive_place,
           today_airflight.start_time start_time,
           today_airflight.arrive_time arrive_time
    from
    (select afid,alid,start_time,arrive_time from t_airflight where DATEDIFF(dd, start_time, GETDATE())=0) today_airflight,t_airline T
    where today_airflight.alid = T.alid

-- ticket Info
select afid,t_airline.alid,start_time,arrive_time,
       tourist_price,first_price,business_price,start_place,arrive_place from
(select * from t_airflight where afid = 'G0027') info,t_airline
where info.alid=t_airline.alid

-- only for pageable
select top 3 * from today_ticket_simple
where afid not in (
    select top 6 afid from today_ticket_simple
)

select count(tid) from t_ticket where seat_type='h' and afid='G0027'
