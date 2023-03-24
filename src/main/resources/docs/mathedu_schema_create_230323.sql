create database if not exists mathedu;
use mathedu;
create table if not exists teacher_info (
    teacher_seq	int	not null	auto_increment	primary key,
    teacher_id	varchar(10)	not null		unique key,
    teacher_pwd	varchar(64)	not null		,
    teacher_img	varchar(255)	not null	default 'default.jpg'	,
    teacher_status	int	not null	default 1	,
    teacher_regdt	datetime	not null	default CURRENT_TIMESTAMP
);

create table if not exists school_info (
    school_seq	int	not null	auto_increment	primary key,
    school_name	varchar(20)	not null		unique key
);

create table if not exists student_info (
    stu_seq	int	not null	auto_increment	primary key,
    stu_id	varchar(8)	not null		unique key,
    stu_pwd	varchar(64)	not null		,
    stu_birth_year	int	not null		,
    stu_birth_month	int	not null		,
    stu_birth_date	int	not null		,
    stu_school_seq	int	not null		,
    stu_grade	int	not null		,
    stu_phone	varchar(16)	null		,
    stu_alternate_phone	varchar(16)	not null		,
    stu_image	varchar(255)	null	default 'default.jpg'	,
    stu_regdt	datetime	not null	default CURRENT_TIMESTAMP,
    foreign key(stu_school_seq) references school_info(school_seq)
    on delete cascade on update cascade
);

create table if not exists class_info (
    class_seq	int	not null	auto_increment	primary key,
    class_name	varchar(20)	not null		,
    class_grade	int	not null		,
    class_days	varchar(16)	not null		,
    class_opendt	datetime	not null		,
    class_closedt	datetime	not null		,
    class_starttime	time	not null		,
    class_endtime	time	not null		,
    class_total_hours	float	not null		,
    class_teacher_seq	int	not null,
    foreign key(class_teacher_seq) references teacher_info(teacher_seq)
    on delete cascade on update cascade
);
create table if not exists exam_info (
exam_seq	int	not null	auto_increment	primary key,
    exam_name	varchar(50)	not null		,
    exam_date	datetime	not null		,
    exam_class_seq	int	not null,
    foreign key(exam_class_seq) references class_info(class_seq)
    on delete cascade on update cascade
);
create table if not exists exam_scores (
    exscore_seq	int	not null	auto_increment	primary key,
    exscore_exam_seq	int	not null,
    exscore_stu_seq	int	not null,
    exscore_score	int	not null,
    foreign key(exscore_exam_seq) references exam_info(exam_seq)
    on delete cascade on update cascade,
    foreign key(exscore_stu_seq) references student_info(stu_seq)
    on delete cascade on update cascade
);
create table if not exists notice_info(
    notice_seq	int	not null	auto_increment	primary key,
    notice_title	varchar(255)	not null		,
    notice_content	text	not null		,
    notice_teacher_seq	int	not null,
    notice_class_seq	int	not null,
    foreign key(notice_teacher_seq) references teacher_info(teacher_seq)
    on delete cascade on update cascade,
    foreign key(notice_class_seq) references class_info(class_seq)
    on delete cascade on update cascade
);
create table if not exists notice_info_file (
    nfile_seq	int	not null	auto_increment	primary key,
    nfile_name	varchar(255)	not null		,
    nfile_notice_seq	int	not null,
    foreign key(nfile_notice_seq) references notice_info(notice_seq)
    on delete cascade on update cascade
);
create table if not exists bbs_info (
    bbs_seq	int	not null	auto_increment	primary key,
    bbs_title	varchar(255)	not null		,
    bbs_content	text	not null		,
    bbs_teacher_seq	int	not null,
    bbs_class_seq	int	not null,
    foreign key(bbs_teacher_seq) references teacher_info(teacher_seq)
    on delete cascade on update cascade,
    foreign key(bbs_class_seq) references class_info(class_seq)
    on delete cascade on update cascade
);
create table if not exists bbs_info_file (
    bfile_seq	int	not null	auto_increment	primary key,
    bfile_name	varchar(255)	not null		,
    bfile_notice_seq	int	not null,
    foreign key(bfile_notice_seq) references bbs_info(bbs_seq)
    on delete cascade on update cascade
);
create table if not exists teacher_class_conn (
    tcc_seq	int	not null	auto_increment	primary key,
    tcc_teacher_seq	int	not null,
    tcc_class_seq	int	not null,
    foreign key(tcc_teacher_seq) references teacher_info(teacher_seq)
    on delete cascade on update cascade,
    foreign key(tcc_class_seq) references class_info(class_seq)
    on delete cascade on update cascade
);
create table if not exists student_class_conn (
    scc_seq	int	not null	auto_increment	primary key,
    scc_stu_seq	int	not null,
    scc_class_seq	int	not null	,
    foreign key(scc_stu_seq) references student_info(stu_seq)
    on delete cascade on update cascade,
    foreign key(scc_class_seq) references class_info(class_seq)
    on delete cascade on update cascade
);
-- create table if not exists exam_class_conn (
--     ecc_seq	int	not null	auto_increment	primary key,
--     ecc_exam_seq	int	not null,
--     ecc_class_seq	int	not null,
--     foreign key(ecc_exam_seq) references exam_info(exam_seq)
--     on delete cascade on update cascade,
--     foreign key(ecc_class_seq) references class_info(class_seq)
--     on delete cascade on update cascade
-- );
create table if not exists admin_info (
    admin_seq	int	not null	auto_increment	primary key,
    admin_id	varchar(10)	not null		unique key,
    admin_pwd	varchar(64)	not null		,
    admin_status	int	not null	default 1	,
    admin_regdt	datetime	not null	default CURRENT_TIMESTAMP	
);