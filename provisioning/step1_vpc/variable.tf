#######################
# Required
#######################
variable "access_key" {}
variable "secret_key" {}
variable "aws_id" {}
variable "app_name" {}
variable "region" {}
variable "az1" {}
variable "az2" {}
variable "az3" {}
variable "myip" {}

#######################
# Option
#######################
variable "root_segment" {
  default = "192.168.0.0/16"
}

variable "public_segment1" {
  default = "192.168.200.0/24"
}

variable "public_segment2" {
  default = "192.168.201.0/24"
}

variable "public_segment3" {
  default = "192.168.202.0/24"
}


variable "db_instance_type" {
  default = "db.t2.small"
}