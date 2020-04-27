mysql> create database demoservice;
mysql> use demoservice


create table post(
   id VARCHAR(15) NOT NULL ,
   title VARCHAR(1000) NOT NULL,
   content VARCHAR(4000) NOT NULL,
   status VARCHAR(100) NOT NULL,
   tag VARCHAR(1000) NOT NULL,
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( id )
);

INSERT INTO post (id, title, content, status, tag )
VALUES (5, 'Test title','this is first post','active','tag1,tag2');


CREATE TABLE country (
  country_id varchar(100) NOT NULL DEFAULT '' COMMENT 'ISO 3661-1 alpha-2',
  name varchar(100) NOT NULL,
  abv3 varchar(100) DEFAULT NULL COMMENT 'ISO 3661-1 alpha-3',
  abv3_alt varchar(100) DEFAULT NULL,
  code INTEGER DEFAULT NULL COMMENT 'ISO 3661-1 numeric',
  slug varchar(100)  NOT NULL,
  create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (country_id),
  UNIQUE KEY slug (slug)
);


CREATE TABLE school(
   school_id VARCHAR(30) NOT NULL ,
   country_id VARCHAR(30) NOT NULL ,
   state VARCHAR(100) NOT NULL,
   school_name VARCHAR(100) NOT NULL,
   school_dname VARCHAR(100) NOT NULL,
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( school_id )
);

CREATE TABLE department(
   department_id VARCHAR(30) NOT NULL ,
   school_id VARCHAR(30) NOT NULL ,
   department_name VARCHAR(100) NOT NULL,
   department_dname VARCHAR(100) NOT NULL,
   department_code VARCHAR(100) NOT NULL,
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( department_id )
);

CREATE TABLE course(
   course_id VARCHAR(30) NOT NULL ,
   department_id VARCHAR(30) NOT NULL ,
   course_name VARCHAR(100) NOT NULL,
   course_dname VARCHAR(100) NOT NULL,
   course_code VARCHAR(100) NOT NULL,
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( course_id )
);


INSERT INTO country (name,country_id,abv3,abv3_alt,code,slug) VALUES
('Afghanistan','AF','AFG',NULL,4,'afghanistan'),
('Aland Islands','AX','ALA',NULL,248,'aland-islands'),
('Albania','AL','ALB',NULL,8,'albania'),
('Algeria','DZ','DZA',NULL,12,'algeria'),
('American Samoa','AS','ASM',NULL,16,'american-samoa'),
('Andorra','AD','AND',NULL,20,'andorra'),
('Angola','AO','AGO',NULL,24,'angola'),
('Anguilla','AI','AIA',NULL,660,'anguilla'),
('Antigua and Barbuda','AG','ATG',NULL,28,'antigua-and-barbuda'),
('Argentina','AR','ARG',NULL,32,'argentina'),
('Armenia','AM','ARM',NULL,51,'armenia'),
('Aruba','AW','ABW',NULL,533,'aruba'),
('Australia','AU','AUS',NULL,36,'australia'),
('Austria','AT','AUT',NULL,40,'austria'),
('Azerbaijan','AZ','AZE',NULL,31,'azerbaijan'),
('Bahamas','BS','BHS',NULL,44,'bahamas'),
('Bahrain','BH','BHR',NULL,48,'bahrain'),
('Bangladesh','BD','BGD',NULL,50,'bangladesh'),
('Barbados','BB','BRB',NULL,52,'barbados'),
('Belarus','BY','BLR',NULL,112,'belarus'),
('Belgium','BE','BEL',NULL,56,'belgium'),
('Belize','BZ','BLZ',NULL,84,'belize'),
('Benin','BJ','BEN',NULL,204,'benin'),
('Bermuda','BM','BMU',NULL,60,'bermuda'),
('Bhutan','BT','BTN',NULL,64,'bhutan'),
('Bolivia','BO','BOL',NULL,68,'bolivia'),
('Bosnia and Herzegovina','BA','BIH',NULL,70,'bosnia-and-herzegovina'),
('Botswana','BW','BWA',NULL,72,'botswana'),
('Brazil','BR','BRA',NULL,76,'brazil'),
('British Virgin Islands','VG','VGB',NULL,92,'british-virgin-islands'),
('Brunei Darussalam','BN','BRN',NULL,96,'brunei-darussalam'),
('Bulgaria','BG','BGR',NULL,100,'bulgaria'),
('Burkina Faso','BF','BFA',NULL,854,'burkina-faso'),
('Burundi','BI','BDI',NULL,108,'burundi'),
('Cambodia','KH','KHM',NULL,116,'cambodia'),
('Cameroon','CM','CMR',NULL,120,'cameroon'),
('Canada','CA','CAN',NULL,124,'canada'),
('Cape Verde','CV','CPV',NULL,132,'cape-verde'),
('Cayman Islands','KY','CYM',NULL,136,'cayman-islands'),
('Central African Republic','CF','CAF',NULL,140,'central-african-republic'),
('Chad','TD','TCD',NULL,148,'chad'),
('Chile','CL','CHL','CHI',152,'chile'),
('China','CN','CHN',NULL,156,'china'),
('Colombia','CO','COL',NULL,170,'colombia'),
('Comoros','KM','COM',NULL,174,'comoros'),
('Congo','CG','COG',NULL,178,'congo'),
('Cook Islands','CK','COK',NULL,184,'cook-islands'),
('Costa Rica','CR','CRI',NULL,188,'costa-rica'),
('Cote d\'Ivoire','CI','CIV',NULL,384,'cote-divoire'),
('Croatia','HR','HRV',NULL,191,'croatia'),
('Cuba','CU','CUB',NULL,192,'cuba'),
('Cyprus','CY','CYP',NULL,196,'cyprus'),
('Czech Republic','CZ','CZE',NULL,203,'czech-republic'),
('Democratic Republic of the Congo','CD','COD',NULL,180,'democratic-republic-of-congo'),
('Denmark','DK','DNK',NULL,208,'denmark'),
('Djibouti','DJ','DJI',NULL,262,'djibouti'),
('Dominica','DM','DMA',NULL,212,'dominica'),
('Dominican Republic','DO','DOM',NULL,214,'dominican-republic'),
('Ecuador','EC','ECU',NULL,218,'ecuador'),
('Egypt','EG','EGY',NULL,818,'egypt'),
('El Salvador','SV','SLV',NULL,222,'el-salvador'),
('Equatorial Guinea','GQ','GNQ',NULL,226,'equatorial-guinea'),
('Eritrea','ER','ERI',NULL,232,'eritrea'),
('Estonia','EE','EST',NULL,233,'estonia'),
('Ethiopia','ET','ETH',NULL,231,'ethiopia'),
('Faeroe Islands','FO','FRO',NULL,234,'faeroe-islands'),
('Falkland Islands','FK','FLK',NULL,238,'falkland-islands'),
('Fiji','FJ','FJI',NULL,242,'fiji'),
('Finland','FI','FIN',NULL,246,'finland'),
('France','FR','FRA',NULL,250,'france'),
('French Guiana','GF','GUF',NULL,254,'french-guiana'),
('French Polynesia','PF','PYF',NULL,258,'french-polynesia'),
('Gabon','GA','GAB',NULL,266,'gabon'),
('Gambia','GM','GMB',NULL,270,'gambia'),
('Georgia','GE','GEO',NULL,268,'georgia'),
('Germany','DE','DEU',NULL,276,'germany'),
('Ghana','GH','GHA',NULL,288,'ghana'),
('Gibraltar','GI','GIB',NULL,292,'gibraltar'),
('Greece','GR','GRC',NULL,300,'greece'),
('Greenland','GL','GRL',NULL,304,'greenland'),
('Grenada','GD','GRD',NULL,308,'grenada'),
('Guadeloupe','GP','GLP',NULL,312,'guadeloupe'),
('Guam','GU','GUM',NULL,316,'guam'),
('Guatemala','GT','GTM',NULL,320,'guatemala'),
('Guernsey','GG','GGY',NULL,831,'guernsey'),
('Guinea','GN','GIN',NULL,324,'guinea'),
('Guinea-Bissau','GW','GNB',NULL,624,'guinea-bissau'),
('Guyana','GY','GUY',NULL,328,'guyana'),
('Haiti','HT','HTI',NULL,332,'haiti'),
('Holy See','VA','VAT',NULL,336,'holy-see'),
('Honduras','HN','HND',NULL,340,'honduras'),
('Hong Kong','HK','HKG',NULL,344,'hong-kong'),
('Hungary','HU','HUN',NULL,348,'hungary'),
('Iceland','IS','ISL',NULL,352,'iceland'),
('India','IN','IND',NULL,356,'india'),
('Indonesia','ID','IDN',NULL,360,'indonesia'),
('Iran','IR','IRN',NULL,364,'iran'),
('Iraq','IQ','IRQ',NULL,368,'iraq'),
('Ireland','IE','IRL',NULL,372,'ireland'),
('Isle of Man','IM','IMN',NULL,833,'isle-of-man'),
('Israel','IL','ISR',NULL,376,'israel'),
('Italy','IT','ITA',NULL,380,'italy'),
('Jamaica','JM','JAM',NULL,388,'jamaica'),
('Japan','JP','JPN',NULL,392,'japan'),
('Jersey','JE','JEY',NULL,832,'jersey'),
('Jordan','JO','JOR',NULL,400,'jordan'),
('Kazakhstan','KZ','KAZ',NULL,398,'kazakhstan'),
('Kenya','KE','KEN',NULL,404,'kenya'),
('Kiribati','KI','KIR',NULL,296,'kiribati'),
('Kuwait','KW','KWT',NULL,414,'kuwait'),
('Kyrgyzstan','KG','KGZ',NULL,417,'kyrgyzstan'),
('Laos','LA','LAO',NULL,418,'laos'),
('Latvia','LV','LVA',NULL,428,'latvia'),
('Lebanon','LB','LBN',NULL,422,'lebanon'),
('Lesotho','LS','LSO',NULL,426,'lesotho'),
('Liberia','LR','LBR',NULL,430,'liberia'),
('Libyan Arab Jamahiriya','LY','LBY',NULL,434,'libyan-arab-jamahiriya'),
('Liechtenstein','LI','LIE',NULL,438,'liechtenstein'),
('Lithuania','LT','LTU',NULL,440,'lithuania'),
('Luxembourg','LU','LUX',NULL,442,'luxembourg'),
('Macao','MO','MAC',NULL,446,'macao'),
('Macedonia','MK','MKD',NULL,807,'macedonia'),
('Madagascar','MG','MDG',NULL,450,'madagascar'),
('Malawi','MW','MWI',NULL,454,'malawi'),
('Malaysia','MY','MYS',NULL,458,'malaysia'),
('Maldives','MV','MDV',NULL,462,'maldives'),
('Mali','ML','MLI',NULL,466,'mali'),
('Malta','MT','MLT',NULL,470,'malta'),
('Marshall Islands','MH','MHL',NULL,584,'marshall-islands'),
('Martinique','MQ','MTQ',NULL,474,'martinique'),
('Mauritania','MR','MRT',NULL,478,'mauritania'),
('Mauritius','MU','MUS',NULL,480,'mauritius'),
('Mayotte','YT','MYT',NULL,175,'mayotte'),
('Mexico','MX','MEX',NULL,484,'mexico'),
('Micronesia','FM','FSM',NULL,583,'micronesia'),
('Moldova','MD','MDA',NULL,498,'moldova'),
('Monaco','MC','MCO',NULL,492,'monaco'),
('Mongolia','MN','MNG',NULL,496,'mongolia'),
('Montenegro','ME','MNE',NULL,499,'montenegro'),
('Montserrat','MS','MSR',NULL,500,'montserrat'),
('Morocco','MA','MAR',NULL,504,'morocco'),
('Mozambique','MZ','MOZ',NULL,508,'mozambique'),
('Myanmar','MM','MMR','BUR',104,'myanmar'),
('Namibia','NA','NAM',NULL,516,'namibia'),
('Nauru','NR','NRU',NULL,520,'nauru'),
('Nepal','NP','NPL',NULL,524,'nepal'),
('Netherlands','NL','NLD',NULL,528,'netherlands'),
('Netherlands Antilles','AN','ANT',NULL,530,'netherlands-antilles'),
('New Caledonia','NC','NCL',NULL,540,'new-caledonia'),
('New Zealand','NZ','NZL',NULL,554,'new-zealand'),
('Nicaragua','NI','NIC',NULL,558,'nicaragua'),
('Niger','NE','NER',NULL,562,'niger'),
('Nigeria','NG','NGA',NULL,566,'nigeria'),
('Niue','NU','NIU',NULL,570,'niue'),
('Norfolk Island','NF','NFK',NULL,574,'norfolk-island'),
('North Korea','KP','PRK',NULL,408,'north-korea'),
('Northern Mariana Islands','MP','MNP',NULL,580,'northern-mariana-islands'),
('Norway','NO','NOR',NULL,578,'norway'),
('Oman','OM','OMN',NULL,512,'oman'),
('Pakistan','PK','PAK',NULL,586,'pakistan'),
('Palau','PW','PLW',NULL,585,'palau'),
('Palestine','PS','PSE',NULL,275,'palestine'),
('Panama','PA','PAN',NULL,591,'panama'),
('Papua New Guinea','PG','PNG',NULL,598,'papua-new-guinea'),
('Paraguay','PY','PRY',NULL,600,'paraguay'),
('Peru','PE','PER',NULL,604,'peru'),
('Philippines','PH','PHL',NULL,608,'philippines'),
('Pitcairn','PN','PCN',NULL,612,'pitcairn'),
('Poland','PL','POL',NULL,616,'poland'),
('Portugal','PT','PRT',NULL,620,'portugal'),
('Puerto Rico','PR','PRI',NULL,630,'puerto-rico'),
('Qatar','QA','QAT',NULL,634,'qatar'),
('Reunion','RE','REU',NULL,638,'reunion'),
('Romania','RO','ROU','ROM',642,'romania'),
('Russian Federation','RU','RUS',NULL,643,'russian-federation'),
('Rwanda','RW','RWA',NULL,646,'rwanda'),
('Saint Helena','SH','SHN',NULL,654,'saint-helena'),
('Saint Kitts and Nevis','KN','KNA',NULL,659,'saint-kitts-and-nevis'),
('Saint Lucia','LC','LCA',NULL,662,'saint-lucia'),
('Saint Pierre and Miquelon','PM','SPM',NULL,666,'saint-pierre-and-miquelon'),
('Saint Vincent and the Grenadines','VC','VCT',NULL,670,'saint-vincent-and-grenadines'),
('Saint-Barthelemy','BL','BLM',NULL,652,'saint-barthelemy'),
('Saint-Martin','MF','MAF',NULL,663,'saint-martin'),
('Samoa','WS','WSM',NULL,882,'samoa'),
('San Marino','SM','SMR',NULL,674,'san-marino'),
('Sao Tome and Principe','ST','STP',NULL,678,'sao-tome-and-principe'),
('Saudi Arabia','SA','SAU',NULL,682,'saudi-arabia'),
('Senegal','SN','SEN',NULL,686,'senegal'),
('Serbia','RS','SRB',NULL,688,'serbia'),
('Seychelles','SC','SYC',NULL,690,'seychelles'),
('Sierra Leone','SL','SLE',NULL,694,'sierra-leone'),
('Singapore','SG','SGP',NULL,702,'singapore'),
('Slovakia','SK','SVK',NULL,703,'slovakia'),
('Slovenia','SI','SVN',NULL,705,'slovenia'),
('Solomon Islands','SB','SLB',NULL,90,'solomon-islands'),
('Somalia','SO','SOM',NULL,706,'somalia'),
('South Africa','ZA','ZAF',NULL,710,'south-africa'),
('South Korea','KR','KOR',NULL,410,'south-korea'),
('South Sudan','SS','SSD',NULL,728,'south-sudan'),
('Spain','ES','ESP',NULL,724,'spain'),
('Sri Lanka','LK','LKA',NULL,144,'sri-lanka'),
('Sudan','SD','SDN',NULL,729,'sudan'),
('Suriname','SR','SUR',NULL,740,'suriname'),
('Svalbard and Jan Mayen Islands','SJ','SJM',NULL,744,'svalbard-and-jan-mayen-islands'),
('Swaziland','SZ','SWZ',NULL,748,'swaziland'),
('Sweden','SE','SWE',NULL,752,'sweden'),
('Switzerland','CH','CHE',NULL,756,'switzerland'),
('Syrian Arab Republic','SY','SYR',NULL,760,'syrian-arab-republic'),
('Tajikistan','TJ','TJK',NULL,762,'tajikistan'),
('Tanzania','TZ','TZA',NULL,834,'tanzania'),
('Thailand','TH','THA',NULL,764,'thailand'),
('Timor-Leste','TP','TLS',NULL,626,'timor-leste'),
('Togo','TG','TGO',NULL,768,'togo'),
('Tokelau','TK','TKL',NULL,772,'tokelau'),
('Tonga','TO','TON',NULL,776,'tonga'),
('Trinidad and Tobago','TT','TTO',NULL,780,'trinidad-and-tobago'),
('Tunisia','TN','TUN',NULL,788,'tunisia'),
('Turkey','TR','TUR',NULL,792,'turkey'),
('Turkmenistan','TM','TKM',NULL,795,'turkmenistan'),
('Turks and Caicos Islands','TC','TCA',NULL,796,'turks-and-caicos-islands'),
('Tuvalu','TV','TUV',NULL,798,'tuvalu'),
('U.S. Virgin Islands','VI','VIR',NULL,850,'us-virgin-islands'),
('Uganda','UG','UGA',NULL,800,'uganda'),
('Ukraine','UA','UKR',NULL,804,'ukraine'),
('United Arab Emirates','AE','ARE',NULL,784,'united-arab-emirates'),
('United Kingdom','UK','GBR',NULL,826,'united-kingdom'),
('United States','US','USA',NULL,840,'united-states'),
('Uruguay','UY','URY',NULL,858,'uruguay'),
('Uzbekistan','UZ','UZB',NULL,860,'uzbekistan'),
('Vanuatu','VU','VUT',NULL,548,'vanuatu'),
('Venezuela','VE','VEN',NULL,862,'venezuela'),
('Viet Nam','VN','VNM',NULL,704,'viet-nam'),
('Wallis and Futuna Islands','WF','WLF',NULL,876,'wallis-and-futuna-islands'),
('Western Sahara','EH','ESH',NULL,732,'western-sahara'),
('Yemen','YE','YEM',NULL,887,'yemen'),
('Zambia','ZM','ZMB',NULL,894,'zambia'),
('Zimbabwe','ZW','ZWE',NULL,716,'zimbabwe');



# ******************* User table ******************** #
CREATE TABLE user(
   id VARCHAR(50) NOT NULL ,
   username VARCHAR(50) NOT NULL,
   fname VARCHAR(50) NOT NULL,
   lname VARCHAR(50) NOT NULL,
   old_password VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   secure_salt  VARCHAR(50) NOT NULL,
   school_id VARCHAR(50) NOT NULL,   
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( id )
);
