resource "aws_db_subnet_group" "aurora_subnet_group" {
  name = "${var.app_name}-aurora-db-subnet-group"
  subnet_ids = [
    "${data.aws_subnet.public_1.id}", "${data.aws_subnet.public_2.id}", "${data.aws_subnet.public_3.id}"
  ]

  tags = {
    Name = "${var.app_name}-aurora-db-subnet-group"
    VPC  = "${data.aws_vpc.selected.id}"
  }
}

resource "aws_rds_cluster" "default" {
  cluster_identifier              = "${var.app_name}-aurora-cluster"
  engine                          = "aurora-postgresql"
  engine_version                  = "11.12"
  master_username                 = "postgres"
  master_password                 = "postgres"
  database_name                   = "demo"
  vpc_security_group_ids          = ["${data.aws_security_group.private.id}"]
  db_subnet_group_name            = aws_db_subnet_group.aurora_subnet_group.name
  db_cluster_parameter_group_name = aws_rds_cluster_parameter_group.default.name
  final_snapshot_identifier = "${var.app_name}-aurora-cluster-final"
}

resource "aws_rds_cluster_instance" "cluster_instances" {
  count                        = 1
  cluster_identifier           = aws_rds_cluster.default.id
  identifier                   = "${var.app_name}-aurora-cluster-${count.index}"
  publicly_accessible             = true
  engine                       = aws_rds_cluster.default.engine
  engine_version               = aws_rds_cluster.default.engine_version
  instance_class               = var.db_instance_type
  db_subnet_group_name         = aws_db_subnet_group.aurora_subnet_group.name
  db_parameter_group_name = aws_db_parameter_group.default.name
  performance_insights_enabled = false
}

resource "aws_rds_cluster_parameter_group" "default" {
  name   = "rds-cluster-pg"
  family = "aurora-postgresql11"
}

resource "aws_db_parameter_group" "default" {
  name   = "rds-db-pg"
  family = "aurora-postgresql11"
  # parameter {
  #   apply_method = "pending-reboot"
  #   name  = "shared_preload_libraries"
  #   value = "pg_stat_statements,pg_hint_plan"
  # }
}
