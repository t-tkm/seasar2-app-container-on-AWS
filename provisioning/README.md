# TF provisioning
## prepare
```
% asdf list
terraform
  1.1.9

% terraform -v
Terraform v1.1.9
on darwin_arm64
```

## work logs
```
% cd step1_vpc_setting
% terraform init 
% terraform validate
% terraform plan -var-file ../my.tfvars
% terraform apply -var-file ../my.tfvars
```

## appendix
* S3にtfstate用のバケット作成
* m1-terraform-provider-helperを活用
