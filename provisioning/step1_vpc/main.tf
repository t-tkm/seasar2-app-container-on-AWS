terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">1.16.0"
    }
    template = {
      source  = "hashicorp/template"
      version = ">1.0.0"
    }
  }
  backend "s3" {
    bucket = "t-tkm-tfstate"
    key    = "step1.tfstate"
    region = "ap-northeast-1"
  }
}

provider "aws" {
  access_key = var.access_key
  secret_key = var.secret_key
  region     = var.region
}