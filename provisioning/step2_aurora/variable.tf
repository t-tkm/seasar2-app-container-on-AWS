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
  default = "db.t3.medium"
}

#######################
# get current id
#######################

# get vpc id
data "aws_vpc" "selected" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*"]
  }
}

# get subnet id
data "aws_subnet" "public_1" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*public-subnet1*"]
  }
}

data "aws_subnet" "public_2" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*public-subnet2*"]
  }
}

data "aws_subnet" "public_3" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*public-subnet3*"]
  }
}

# get security group id
data "aws_security_group" "public" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*public-firewall*"]
  }
}

data "aws_security_group" "private" {
  filter {
    name   = "tag-value"
    values = ["*${var.app_name}*private-firewall*"]
  }
}